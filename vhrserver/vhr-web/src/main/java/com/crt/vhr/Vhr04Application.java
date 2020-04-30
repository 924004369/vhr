package com.crt.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.crt.vhr.mapper")
public class Vhr04Application {

    public static void main(String[] args) {
        SpringApplication.run(Vhr04Application.class, args);
    }

}
