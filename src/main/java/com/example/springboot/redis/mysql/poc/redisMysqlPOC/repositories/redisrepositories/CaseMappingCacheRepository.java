package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.redisrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCaseAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CaseMappingCacheRepository extends JpaRepository<CaseIdMapping, AscCaseAsID> {

    CaseIdMapping findByAscCaseAsID(AscCaseAsID ascCaseAsID);

//    public void save(CaseIdMapping caseIdMapping);
//
//    public CaseIdMapping find(String id);
//
//    public Map<Object, Object> findAll();
//
//    public void delete(String id);

}
