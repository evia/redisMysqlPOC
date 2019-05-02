package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscWorkstep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AscCaseCacheRepoImpl /*implements AscCaseCacheRepository*/ {

//    RedisTemplate<String, String> redisTemplate;
//
//    @Autowired
//    public AscCaseCacheRepoImpl(RedisTemplate<String, String> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    private static String ASC_CASE_KEY = "AscCase";
//
//    @Override
//    public void save(AscCase ascCase) {
//        this.redisTemplate.opsForHash().put(ASC_CASE_KEY, ascCase.getAscCaseId(), ascCase);
//    }
//
//    @Override
//    public void update(AscCase ascCase) {
////        PartialUpdate<AscCase> ascCaseUpdate = new PartialUpdate<AscCase>(caseUpdateRequest.getAscCaseId(), AscCase.class)
////                .set("workstep_id", new AscWorkstep(AscWorkstep.AscWorkstepType.RISK_ACCOUNT_REVIEW));
////
////        redisTemplate.update(ascCaseUpdate);
//
//    }
//
//    @Override
//    public AscCase find(String id) {
//        return null;
//    }
//
//    @Override
//    public Map<Object, Object> findAll() {
//        return this.redisTemplate.opsForHash().entries(ASC_CASE_KEY);
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
}
