package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseIdMapping;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
//public class CaseMappingCacheRepoImpl implements CaseMappingCacheRepository {
public class CaseMappingCacheRepoImpl  {

//    RedisTemplate redisTemplate;
//
//    @Autowired
//    public CaseMappingCacheRepoImpl(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    private static String CASE_ID_MAPPING_KEY = "CaseIdMapping";
//
//    @Override
//    public void save(CaseIdMapping caseIdMapping) {
//        String caseMappinghashKey = caseIdMapping.getAscCaseAsID().getAscCase().getAscCaseId();
//        this.redisTemplate.opsForHash().put(CASE_ID_MAPPING_KEY, caseMappinghashKey, caseIdMapping);
//    }
//
//    @Override
//    public CaseIdMapping find(String id) {
//        return null;
//    }
//
//    @Override
//    public Map<Object, Object> findAll() {
//        return this.redisTemplate.opsForHash().entries(CASE_ID_MAPPING_KEY);
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
}
