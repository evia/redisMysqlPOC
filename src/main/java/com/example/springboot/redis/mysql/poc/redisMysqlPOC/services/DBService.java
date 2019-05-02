package com.example.springboot.redis.mysql.poc.redisMysqlPOC.services;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class DBService {

    private SfCaseService sfCaseService;
    private AscCaseService ascCaseService;
    private CaseStatusService caseStatusService;
    private CaseAreaService caseAreaService;

    private static final Logger logger = LoggerFactory.getLogger(SfCaseService.class);

    @Autowired
    public DBService(SfCaseService sfCaseService, AscCaseService ascCaseService, CaseStatusService caseStatusService, CaseAreaService caseAreaService) {
        this.sfCaseService = sfCaseService;
        this.ascCaseService = ascCaseService;
        this.caseStatusService = caseStatusService;
        this.caseAreaService = caseAreaService;
    }

    public boolean caseCreation(@Valid SfCase sfCase, @Valid AscCase ascCase) throws Exception {
        logger.info("DB Service, case creation: sf_case_id= " + sfCase.getSfCaseNum() + ", asc_case_id= " + ascCase.getAscCaseId());
        return sfCaseService.onSFCaseCreation(sfCase, ascCase);
    }

    public AscCase createAscCase(AscCase ascCase) throws Exception {
        return ascCaseService.insertOrUpdateAscCase(ascCase);
    }

    public AscCase updateAscCaseStatus(AscCase ascCase) throws Exception {
        AscCase updatedAscCase = ascCaseService.getAscCaseById(ascCase.getAscCaseId());
        updatedAscCase.setWorkstep(ascCase.getWorkstep());
        return ascCaseService.insertOrUpdateAscCase(updatedAscCase);
    }

    public CaseIdMapping getSfCaseByAscCaseId(AscCase ascCase) throws Exception {
        return sfCaseService.getSfCaseByAscCaseId(ascCase);
    }

    public CaseStatusMapping findStatusMappingByAscWorkstep(AscWorkstep ascWorkstep) throws Exception {
        return caseStatusService.findStatusMappingByAscWorkstep(ascWorkstep);
    }

    public CaseAreaMapping getSFSbIssueAreaByAscPriorityLvl(AscPriorityLvlAsID id) throws Exception {
        return caseAreaService.getSFSbIssueAreaByAscPriorityLvl(id);
    }

    public boolean onSFCaseUpdate(SfCase sfCase, AscCase ascCase) throws Exception {

        logger.info("DB Service: SF case status update. Sf_case = " + sfCase.getSfCaseNum() + ", Desc = " + sfCase.getStatus());
        return sfCaseService.onSFCaseUpdate(sfCase, ascCase);
    }

    public AscCase getAscCaseById(String id) throws Exception {

        return ascCaseService.getAscCaseById(id);
    }

}
