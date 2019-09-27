package com.jobtracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableJpaRepositories(basePackages={"com.jobtracker"})
@ComponentScan(basePackages={"com.jobtracker"},
    excludeFilters={
        @ComponentScan.Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {
}
