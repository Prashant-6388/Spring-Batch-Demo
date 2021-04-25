package com.pc.test.ipldashbard.repository;

import com.pc.test.ipldashbard.model.MatchRecord;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRecordRepository extends CrudRepository<MatchRecord, Long> {
    
}
