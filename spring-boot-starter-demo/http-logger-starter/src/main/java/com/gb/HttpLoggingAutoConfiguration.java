package com.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gb.http.logging.LoggingFilter;

@Configuration
public class HttpLoggingAutoConfiguration {

    @Bean
    LoggingFilter loggingFilter(){
        return new LoggingFilter();
    }
}
