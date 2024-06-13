package ru.gb.demo.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.gb.demo.lesson1.aspect.Loggable;

@Slf4j
@Loggable
@Component
public class Mario implements Brother {

    @Loggable
    public void method1(String args1, int args2){
        log.info("method1: {} - {}", args1, args2);
    }

    @Loggable
    public String method2(){
        log.info("method2");
        return "value";
    }

    public String method3(){
        throw  new RuntimeException("RuntimeException");
    }

}
