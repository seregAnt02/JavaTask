package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.aspect.TimerAspect;
import ru.gb.http.aop.AopFilter;
import ru.gb.timer.MyServiceTime;

@Configuration
//@EnableConfigurationProperties()
class HttpTimerAutoConfiguration {
    @Bean
    public AopFilter timerAopAspect() {
        return new AopFilter();
    }

    @Bean
    public MyServiceTime serviceTime(){
        return new MyServiceTime();
    }

    @Bean
    public TimerAspect timerAspect(){
        return new TimerAspect();
    }
}
