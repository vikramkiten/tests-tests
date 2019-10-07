package com.verizon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

    @Value("${spring.datasource.driverclassname}")
    private String driverclassname;
    @Value("${spring.datasource.url}")
    private String url;
    private String username;

    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection()
    {
        System.out.println("database connection for dev");
        System.out.println(driverclassname);
       System.out.println(url);
        return "database connection for dev";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection()
    {
        System.out.println("database connection for prod");
        System.out.println(driverclassname);
        System.out.println(url);
        return "database connection for prod";
    }


    @Profile("test")
    @Bean
    public String testDatabaseConnection()
    {
        System.out.println("database connection for test");
        System.out.println(driverclassname);
        System.out.println(url);
        return "database connection for test";
    }

}
