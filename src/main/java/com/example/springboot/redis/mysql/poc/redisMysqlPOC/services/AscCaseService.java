package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.AscCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class) // Rollback the whole transaction for any kind of exception thrown
public class AscCaseService {

    private AscCaseRepository ascCaseRepository;

    @Autowired
    public AscCaseService(AscCaseRepository ascCaseRepository) {
        this.ascCaseRepository = ascCaseRepository;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public AscCase insertOrUpdateAscCase(AscCase ascCase) throws DataAccessException {
        return ascCaseRepository.save(ascCase);
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public AscCase getAscCaseById(String id) throws DataAccessException {
        return ascCaseRepository.findByAscCaseId(id);
    }

}