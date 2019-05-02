package com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories.dbrepositories;

import com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.SfCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SfCaseRepository extends JpaRepository<SfCase, String> {

    SfCase findBySfCaseNum(String num);
}
