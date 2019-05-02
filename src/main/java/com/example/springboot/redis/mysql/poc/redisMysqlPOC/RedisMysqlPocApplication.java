package com.example.springboot.redis.mysql.poc.redisMysqlPOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.springboot.redis.mysql.poc.redisMysqlPOC.repositories"})
public class RedisMysqlPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisMysqlPocApplication.class, args);
	}

}
