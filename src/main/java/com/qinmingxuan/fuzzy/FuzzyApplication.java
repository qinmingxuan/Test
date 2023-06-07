package com.qinmingxuan.fuzzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.qinmingxuan.fuzzy.mapper")
public class FuzzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuzzyApplication.class, args);
    }

}
