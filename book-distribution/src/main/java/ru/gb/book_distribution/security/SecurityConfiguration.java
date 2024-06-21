package ru.gb.book_distribution.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
//@Profile("test") // !!! добавил как отключить Spring Security для определенного профиля @Profile("test")
public class SecurityConfiguration {

    /*@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/**"));
    }*/

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/book/**").permitAll()
                )
                //.formLogin(Customizer.withDefaults())
                .build();
        //.antMatchers("/").permitAll();

        /*return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/api/resource/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/user/**").hasAuthority("user")
                        //.requestMatchers("/user/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/auth/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .requestMatchers("/user").permitAll()
                        .requestMatchers("/role").permitAll()
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();*/
    }



    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> {
            Map<String, Object> resourceAccess = source.getClaim("resource_access");
            List<String> roles = (List<String>) resourceAccess.get("roles");
            return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });
        return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/api/resource/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/user/**").hasAuthority("user")
                        //.requestMatchers("/user/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/auth/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .requestMatchers("/user").permitAll()
                        .requestMatchers("/role").permitAll()
                        .anyRequest().denyAll()
                )
                //.formLogin(Customizer.withDefaults())
                .oauth2ResourceServer(configurer ->
                        configurer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter)) //Customizer.withDefaults()
                )
                .build();
    }*/
}
