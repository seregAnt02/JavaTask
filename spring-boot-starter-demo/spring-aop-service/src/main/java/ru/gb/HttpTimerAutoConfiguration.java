package ru.gb;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.http.aop.AopFilter;

@Configuration
//@EnableConfigurationProperties()
class HttpTimerAutoConfiguration {
    @Bean
    public AopFilter timerAspect() {
        return new AopFilter();
    }
}
