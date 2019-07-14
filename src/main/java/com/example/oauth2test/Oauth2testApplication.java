package com.example.oauth2test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.oauth2test.mapper")
public class Oauth2testApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2testApplication.class, args);
    }

}
