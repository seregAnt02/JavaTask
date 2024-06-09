package ru.gb.book_distribution.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/api/resource/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/user/**").hasAuthority("user")
                        .requestMatchers("/api/resource/auth/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}