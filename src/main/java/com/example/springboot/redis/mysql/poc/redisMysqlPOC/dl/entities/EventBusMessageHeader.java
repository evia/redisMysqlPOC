package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBusMessageHeader {
    @JsonProperty("intuit_tid")
    String intuitTid;
}
