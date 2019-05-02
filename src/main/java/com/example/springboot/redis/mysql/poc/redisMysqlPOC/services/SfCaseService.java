package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCaseAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseIdMapping;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.AscCaseRepository;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.CaseMappingRepository;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories.SfCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SfCaseService {

    private SfCaseRepository sfCaseRepository;
    private CaseMappingRepository caseMappingRepository;
    private AscCaseRepository ascCaseRepository;


    @Autowired
    public SfCaseService(SfCaseRepository sfCaseRepository, CaseMappingRepository caseMappingRepository, AscCaseRepository ascCaseRepository) {
        this.sfCaseRepository = sfCaseRepository;
        this.caseMappingRepository = caseMappingRepository;
        this.ascCaseRepository = ascCaseRepository;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean onSFCaseCreation(SfCase sfCase, AscCase ascCase) {
        ascCaseRepository.save(ascCase);
        sfCaseRepository.save(sfCase);
        CaseIdMapping caseIdMapping = new CaseIdMapping(new AscCaseAsID(ascCase), sfCase);
        caseMappingRepository.save(caseIdMapping); // save the mapping between Asc Case to SF Case

        return true;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean onSFCaseUpdate(SfCase newSfCase, AscCase newAscCase) throws DataAccessException {
        AscCase updatedAscCase = ascCaseRepository.findByAscCaseId(newAscCase.getAscCaseId());
        updatedAscCase.setWorkstep(newAscCase.getWorkstep());
        updatedAscCase.setClientUpdateTime(newAscCase.getClientUpdateTime());
        SfCase updatedSfCase = sfCaseRepository.findBySfCaseNum(newSfCase.getSfCaseNum());
        updatedSfCase.setStatus(newSfCase.getStatus());
        ascCaseRepository.save(updatedAscCase);
        sfCaseRepository.save(updatedSfCase);
        return true;
    }

    public CaseIdMapping getSfCaseByAscCaseId(AscCase ascCase) {
        return caseMappingRepository.findByAscCaseAsID(new AscCaseAsID(ascCase));
    }
}
