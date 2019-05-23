package com.chinasoftinternational.uav;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.chinasoftinternational.uav")
@MapperScan(value = "com.chinasoftinternational.uav.mapper")
@SpringBootApplication
public class UavApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavApplication.class, args);
    }

}
