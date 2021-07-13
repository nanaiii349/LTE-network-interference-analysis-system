package com.example.Service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.Service.mapper")
public class SerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerApplication.class, args);
    }
}
