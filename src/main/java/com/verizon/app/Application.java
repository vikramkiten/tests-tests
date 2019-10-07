package com.verizon.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.verizon")
@SpringBootApplication(scanBasePackages = "com.verizon")
@EntityScan(basePackages = "com.verizon")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);


    }
}
