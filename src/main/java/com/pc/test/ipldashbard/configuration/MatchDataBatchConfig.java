package com.pc.test.ipldashbard.configuration;

import javax.persistence.EntityManagerFactory;

import com.pc.test.ipldashbard.Processor.MatchDataProcessor;
import com.pc.test.ipldashbard.dto.MatchData;
import com.pc.test.ipldashbard.model.MatchRecord;
import com.pc.test.ipldashbard.repository.MatchRecordRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class MatchDataBatchConfig {

    private static final Logger log = LoggerFactory.getLogger(MatchDataBatchConfig.class);

    public static final String[] INPUT_FIELD_NAMES = new String[] {
        "id", "city", "date", "player_of_match", "venue", "neutral_venue", 
        "team1", "team2", "toss_winner", "toss_decision", "winner", 
        "result", "result_margin", "eliminator", "method", "umpire1", "umpire2"
    };

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    MatchRecordRepository matchRecordRepository;

    @Bean
    public FlatFileItemReader<MatchData> reader() {
        return new FlatFileItemReaderBuilder<MatchData>().name("matchDataReader")
                .resource(new ClassPathResource("IPL Matches 2008-2020.csv")).delimited()
                .names(INPUT_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchData>() {
                    {
                        setTargetType(MatchData.class);
                    }
                }).build();
    }

    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }

    @Bean 
    public ItemWriter<MatchRecord> writer() { 
        JpaItemWriter<MatchRecord> writer = new JpaItemWriter<>(); 
        writer.setEntityManagerFactory(entityManagerFactory); 
        return writer; 
    }

    @Bean
    public Job importMatchDataJob(JobExecutionListener listener) {
        return jobBuilderFactory.get("importMatchDataJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }
 
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<MatchData, MatchRecord>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
 
    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListener() {
 
 
            @Override
            public void beforeJob(JobExecution jobExecution) {
                /**
                 * As of now empty but can add some before job conditions
                 */
            }
 
            @Override
            public void afterJob(JobExecution jobExecution) {
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                    log.info("!!! JOB FINISHED! Time to verify the results");
                    matchRecordRepository.findAll().
                            forEach(matchRecord -> log.info("Found <" + matchRecord.getId() + "> in the database."));
                }
            }
        };
    }
}
