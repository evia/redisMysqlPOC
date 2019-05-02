package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfStatus;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories.SfCaseCacheRepository;
import org.springframework.stereotype.Service;

@Service
public class SfCaseCacheService {

    private SfCaseCacheRepository repo;

    public SfCaseCacheService(SfCaseCacheRepository repo) {
        this.repo = repo;
    }

    public boolean updateSfCase(String sfCaseNum, SfStatus newStatus) {

        SfCase sfCaseToUpdate = repo.findById(sfCaseNum).get();
        sfCaseToUpdate.setStatus(newStatus);
        repo.save(sfCaseToUpdate);
        return true;
    }
}
