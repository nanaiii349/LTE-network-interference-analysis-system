package com.example.Queries;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.Queries.mapper")
//@EnableDiscoveryClient
public class QueApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueApplication.class, args);
    }
}
