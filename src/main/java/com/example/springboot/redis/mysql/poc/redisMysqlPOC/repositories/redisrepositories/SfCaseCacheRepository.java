package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface SfCaseCacheRepository extends JpaRepository<SfCase, String> {

//    public void save(SfCase sfCase);
//
//    public SfCase find(String id);
//
//    public Map<Object, Object> findAll();
//
//    public void delete(String id);

}
