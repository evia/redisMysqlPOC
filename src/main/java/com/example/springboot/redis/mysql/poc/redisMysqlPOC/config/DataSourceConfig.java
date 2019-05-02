package com.example.springboot.redis.mysql.poc.redisMysqlPOC.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/springboothibernatedb");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("pass123");
        return dataSourceBuilder.build();
    }
}