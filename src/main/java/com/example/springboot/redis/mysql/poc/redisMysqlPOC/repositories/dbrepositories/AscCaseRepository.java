package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.AscCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AscCaseRepository extends JpaRepository<AscCase, String> {

    AscCase findByAscCaseId(String id);
}
