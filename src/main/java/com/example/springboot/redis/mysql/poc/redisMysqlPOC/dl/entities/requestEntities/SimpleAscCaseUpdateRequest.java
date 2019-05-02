package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities.requestEntities;

import lombok.Data;

@Data
public class SimpleAscCaseUpdateRequest {
    
    private String ascCaseId;
    private String newStatus;
}
