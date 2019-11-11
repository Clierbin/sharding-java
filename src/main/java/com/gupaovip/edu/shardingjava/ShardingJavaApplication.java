package com.gupaovip.edu.shardingjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gupaovip.edu.shardingjava.dao"},sqlSessionFactoryRef = "sqlSessionFactory")
public class ShardingJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJavaApplication.class, args);
    }

}
