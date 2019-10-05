package com.jobtracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
            .and()
                .authorizeRequests()
                    .antMatchers("/", "/login", "/*.html", "/*.js")
                        .permitAll()
                    .antMatchers("/rest/**")
                        .access("hasAnyRole('BOSS', 'EMPLOYEE')")
            .and()
                .csrf().disable();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails boss =
            User.withUsername("boss").password("{noop}pass").roles("BOSS").build();

        UserDetails empl =
            User.withUsername("empl").password("{noop}pass").roles("EMPLOYEE").build();

        return new InMemoryUserDetailsManager(boss, empl);
    }
}
