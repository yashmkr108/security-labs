package com.yash.securitylabs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(login -> login.disable())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/hello").authenticated()
                                .requestMatchers("/api/greet").permitAll()
                                .requestMatchers("/api/anonymous-info").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/user").permitAll()
                                .anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
