package com.juebingliu.boot4learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
@MapperScan(basePackages = "com.juebingliu.boot4learn.mapper")
public class Boot4learnApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot4learnApplication.class, args);
    }
}
