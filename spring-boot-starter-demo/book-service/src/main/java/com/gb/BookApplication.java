package com.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {

        SpringApplication.run(BookApplication.class, args);
    }

    /*@Bean
    public LoggingFilter loggingFilter(){
        return new LoggingFilter();
    }*/
}