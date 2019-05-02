package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCaseAsID;
import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.CaseIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseMappingRepository  extends JpaRepository<CaseIdMapping, AscCaseAsID> {

    CaseIdMapping findByAscCaseAsID(AscCaseAsID ascCaseAsID);

}
