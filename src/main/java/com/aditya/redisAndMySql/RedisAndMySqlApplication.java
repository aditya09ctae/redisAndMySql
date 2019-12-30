package com.aditya.redisAndMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class RedisAndMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAndMySqlApplication.class, args);
	}

}
