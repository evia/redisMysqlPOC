package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;


import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscPriorityLvlAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseAreaMapping;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.CaseAreaMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class) // Rollback the whole transaction for any kind of exception thrown
public class CaseAreaService {

    private CaseAreaMappingRepository caseAreaMappingRepository;

    @Autowired
    public CaseAreaService(CaseAreaMappingRepository caseAreaMappingRepository){
        this.caseAreaMappingRepository = caseAreaMappingRepository;
    }

    public CaseAreaMapping getSFSbIssueAreaByAscPriorityLvl(AscPriorityLvlAsID id) {
        return caseAreaMappingRepository.findByAscPriorityLvlAsID(id);
    }
}
