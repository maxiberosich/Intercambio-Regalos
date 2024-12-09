package com.maxicb.intercambio_regalos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return httpSecurity.build();
    }

}
