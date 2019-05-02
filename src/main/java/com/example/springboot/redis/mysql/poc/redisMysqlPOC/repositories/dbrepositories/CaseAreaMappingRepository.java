package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories;


import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscPriorityLvlAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseAreaMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseAreaMappingRepository extends JpaRepository<CaseAreaMapping, AscPriorityLvlAsID> {
    CaseAreaMapping findByAscPriorityLvlAsID(AscPriorityLvlAsID id);
}
