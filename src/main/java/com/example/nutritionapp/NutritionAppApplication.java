package com.example.nutritionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@EnableRedisRepositories
public class NutritionAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionAppApplication.class, args);
    }

}
