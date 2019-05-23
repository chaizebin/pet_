package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@MapperScan("com.jk.mapper")
@ComponentScan("com.jk.*")
public class ProviderWdlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderWdlApplication.class, args);
    }

}
