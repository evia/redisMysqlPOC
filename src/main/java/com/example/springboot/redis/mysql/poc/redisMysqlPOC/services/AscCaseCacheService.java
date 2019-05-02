package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscWorkstep;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories.AscCaseCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AscCaseCacheService {

    private AscCaseCacheRepository repo;

    @Autowired
    public AscCaseCacheService(AscCaseCacheRepository ascCaseCacheRepository) {
        this.repo = ascCaseCacheRepository;
    }

    public boolean updateAscCase(String caseId, AscWorkstep newStatus) {
        AscCase ascCaseToUpdate = repo.findById(caseId).get();
        ascCaseToUpdate.setWorkstep(newStatus);
        repo.save(ascCaseToUpdate);
        return true;
    }
}
