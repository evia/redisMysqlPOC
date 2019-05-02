package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscWorkStepAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseStatusMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseStatusMappingRepository extends JpaRepository<CaseStatusMapping, AscWorkStepAsID> {

    CaseStatusMapping findByAscWorkStepAsID(AscWorkStepAsID ascWorkStepAsID);

}
