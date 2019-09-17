package com.jobtracker.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConnectionConfig {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("org.postgresql.Driver");
        bds.setUrl("jdbc:postgresql://localhost:5432/jobtracker_main");
        bds.setUsername("jobtracker_user");
        bds.setPassword("mypass");
        bds.setInitialSize(4);
        return bds;
    }
}
