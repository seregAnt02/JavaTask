package ru.gb.demo.lesson1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AspectRunner {

    private final List<Brother> brothers;

    //private final TimerAspect timerAspect;
    //@EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(){

        //timerAspect.timerAspect()
        log.info("target : {}", brothers);

            for(Brother brother: brothers){
                try {
                    brother.method1("1", 2);
                    brother.method2();
                    //brother.method3();
                }catch (Throwable e){
                    log.info("Exception: {}" + e.getMessage());
                }
            }
    }
}
