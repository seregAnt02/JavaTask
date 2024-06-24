package ru.gb.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.gb.aspect.Timer;

@Slf4j
@Timer
@Component
public class MyServiceTime {

    @Timer
    public void method1(String args1, int args2){
        log.info("method1: {} - {}", args1, args2);
    }
    public String method2(){
        log.info("method2");
        return "value";
    }
}
