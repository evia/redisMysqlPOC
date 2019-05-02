package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscWorkStepAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscWorkstep;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseStatusMapping;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.CaseStatusMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class) // Rollback the whole transaction for any kind of exception thrown
public class CaseStatusService {

    @Autowired
    private CaseStatusMappingRepository caseStatusMappingRepository;

    public CaseStatusMapping findStatusMappingByAscWorkstep(AscWorkstep ascWorkstep) {
        return caseStatusMappingRepository.findByAscWorkStepAsID(new AscWorkStepAsID(ascWorkstep));
    }
}
