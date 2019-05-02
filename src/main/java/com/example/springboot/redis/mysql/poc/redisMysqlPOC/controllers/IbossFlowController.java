package com.example.springboot.redis.mysql.poc.redisMysqlPOC.controllers;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.*;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.requestEntities.SimpleAscCaseUpdateRequest;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.requestEntities.SimpleCaseMapping;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories.AscCaseCacheRepository;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories.CaseMappingCacheRepository;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories.SfCaseCacheRepository;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.services.AscCaseCacheService;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.services.DBService;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.services.SfCaseCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class IbossFlowController {

    private DBService dbService;

    private AscCaseCacheRepository ascCacheRepo;
    private SfCaseCacheRepository sfCacheRepo;
    private CaseMappingCacheRepository mappingCacheRepo;

    private AscCaseCacheService ascCaseCacheService;
    private SfCaseCacheService sfCaseCacheService;

    @Autowired
    public IbossFlowController(DBService dbService, AscCaseCacheRepository ascCacheRepo,
                               SfCaseCacheRepository sfCacheRepo,
                               CaseMappingCacheRepository mappingCacheRepo,
                               AscCaseCacheService ascCaseCacheService,
                               SfCaseCacheService sfCaseCacheService) {
        this.dbService = dbService;
        this.ascCacheRepo = ascCacheRepo;
        this.sfCacheRepo = sfCacheRepo;
        this.mappingCacheRepo = mappingCacheRepo;
        this.ascCaseCacheService = ascCaseCacheService;
        this.sfCaseCacheService = sfCaseCacheService;
    }

    @GetMapping("/all")
    public String getAll() {
        return "all";
    }

    @GetMapping("/createCase")
    public String createCase(@PathVariable String ascCaseNumber) {

        return "mission success, case number got: " + ascCaseNumber;
    }

    @PutMapping("/create")
    String create(@RequestBody SimpleCaseMapping newCaseMapping) {

        long startTime = System.nanoTime();
        AscCase ascCase = new AscCase(newCaseMapping.getAscCaseId(), new AscWorkstep(AscWorkstep.AscWorkstepType.EMPTY), new Timestamp(System.currentTimeMillis()));
        SfCase sfCase = new SfCase(newCaseMapping.getSfCaseId(), new SfStatus(SfStatus.SfStatusType.OPEN));
        try {
            dbService.caseCreation(sfCase, ascCase);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return "the duration of the update task in seconds: " + (double) duration / 1_000_000_000;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error on execution";
        }
    }

    @PutMapping("/createInCache")
    String createInCache(@RequestBody SimpleCaseMapping newCaseMapping) {
        long startTime = System.nanoTime();
        AscCase ascCase = new AscCase(newCaseMapping.getAscCaseId(), new AscWorkstep(AscWorkstep.AscWorkstepType.EMPTY), new Timestamp(System.currentTimeMillis()));
        SfCase sfCase = new SfCase(newCaseMapping.getSfCaseId(), new SfStatus(SfStatus.SfStatusType.OPEN));
        CaseIdMapping caseIdMapping = new CaseIdMapping(new AscCaseAsID(ascCase), sfCase);
        try {
            ascCacheRepo.save(ascCase);
            sfCacheRepo.save(sfCase);
            mappingCacheRepo.save(caseIdMapping);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return "the duration of the update task in seconds: " + (double) duration / 1_000_000_000;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error on execution";
        }
    }

    @PostMapping("/updateInDB")
    String updateInDB(@RequestBody SimpleAscCaseUpdateRequest caseUpdateRequest) {

        try {
            long startTime = System.nanoTime();

            AscCase ascCase = dbService.getAscCaseById(caseUpdateRequest.getAscCaseId());

            AscWorkstep ascWorkstep = new AscWorkstep(AscWorkstep.AscWorkstepType.fromString(caseUpdateRequest.getNewStatus()));
            ascCase.setWorkstep(ascWorkstep);

            SfCase sfCase = dbService.getSfCaseByAscCaseId(ascCase).getSfCase();
            SfStatus newSfStatus = dbService.findStatusMappingByAscWorkstep(ascWorkstep).getSfStatus();
            sfCase.setStatus(newSfStatus);

            dbService.onSFCaseUpdate(sfCase, ascCase);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return "the duration of the update task in seconds: " + (double) duration / 1_000_000_000;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error on execution";
        }
    }


    @PostMapping("/updateInCache")
    String updateInCache(@RequestBody SimpleAscCaseUpdateRequest caseUpdateRequest) {

        try {
            long startTime = System.nanoTime();
            CaseIdMapping caseMapping = mappingCacheRepo.findByAscCaseAsID(new AscCaseAsID(ascCacheRepo.findById(caseUpdateRequest.getAscCaseId()).get()));

            SfCase sfCase = caseMapping.getSfCase();
            sfCaseCacheService.updateSfCase(sfCase.getSfCaseNum(), new SfStatus(SfStatus.SfStatusType.OPEN));

            ascCaseCacheService.updateAscCase(caseUpdateRequest.getAscCaseId(), new AscWorkstep(AscWorkstep.AscWorkstepType.fromString(caseUpdateRequest.getNewStatus())));

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return "the duration of the update task in seconds: " + (double) duration / 1_000_000_000;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error on execution";
        }
    }

//    public static void main(String[] args) {
//        System.out.print("stam");
//
//        Integer initialAscCaseId = 11111111;
//        Integer initialSfCaseId =  22222222;
//
//        DBService db = new DBService()
//
//        for(int i=0; i< 20000; i++) {
//            AscCase ascCase = new AscCase(String.valueOf(initialAscCaseId), new AscWorkstep(AscWorkstep.AscWorkstepType.EMPTY), new Timestamp(System.currentTimeMillis()));
//            SfCase sfCase = new SfCase(String.valueOf(initialSfCaseId), new SfStatus(SfStatus.SfStatusType.OPEN));
//
//        }
//
//
//    }

}
