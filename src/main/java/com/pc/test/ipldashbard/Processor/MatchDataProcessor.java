package com.pc.test.ipldashbard.Processor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.pc.test.ipldashbard.dto.MatchData;
import com.pc.test.ipldashbard.model.MatchRecord;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MatchDataProcessor implements ItemProcessor<MatchData, MatchRecord> {

    @Override
    public MatchRecord process(MatchData matchData) throws Exception {
        
        MatchRecord matchRecord = new MatchRecord();
        
        matchRecord.setId(Long.valueOf(matchData.getId()));
        matchRecord.setCity(matchData.getCity());
        matchRecord.setDate(LocalDate.parse(matchData.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        matchRecord.setMethod(matchData.getMethod());
        matchRecord.setEliminator(matchData.getEliminator()=="Y"?true:false);
        matchRecord.setPlayerOfMatch(matchData.getPlayerOfMatch());
        matchRecord.setResult(matchData.getResult());
        matchRecord.setResultMargin(matchData.getResultMargin());
        matchRecord.setTeam1(matchData.getTeam1());
        matchRecord.setTeam2(matchData.getTeam2());
        matchRecord.setTossWinner(matchData.getTossWinner());
        matchRecord.setVenue(matchData.getVenue());
        
        return matchRecord;
    }
    
}
