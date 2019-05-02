package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AscCaseCacheRepository extends JpaRepository<AscCase, String> {

////    public void save(AscCase ascCase);
//
//    public void update(AscCase ascCase);
//
//    public AscCase find(String id);
//
////    public Map<Object, Object> findAll();
//
//    public void delete(String id);
}
