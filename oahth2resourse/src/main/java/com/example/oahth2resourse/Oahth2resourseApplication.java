package com.example.oahth2resourse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.oahth2resourse.mapper")
public class Oahth2resourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oahth2resourseApplication.class, args);
    }

}
