package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
//public class SfCaseCacheRepoImpl implements SfCaseCacheRepository {
public class SfCaseCacheRepoImpl  {

//    RedisTemplate<String, String> redisTemplate;
//
//    @Autowired
//    public SfCaseCacheRepoImpl(RedisTemplate<String, String> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    private static String SF_CASE_KEY = "SfCase";
//
//    @Override
//    public void save(SfCase sfCase) {
//        this.redisTemplate.opsForHash().put(SF_CASE_KEY, sfCase.getSfCaseNum(), sfCase);
//    }
//
//    @Override
//    public SfCase find(String id) {
//        return null;
//    }
//
//    @Override
//    public Map<Object, Object> findAll() {
//        return this.redisTemplate.opsForHash().entries(SF_CASE_KEY);
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
}
