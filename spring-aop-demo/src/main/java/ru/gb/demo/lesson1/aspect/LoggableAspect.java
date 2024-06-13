package ru.gb.demo.lesson1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggableAspect {

    @Pointcut("within(@ru.gb.demo.lesson1.aspect.Loggable *)")
    public void binsAnnotatedWith(){

    }

    @Pointcut("@annotation(@ru.gb.demo.lesson1.aspect.Loggable)")
    public void methodsAnnotatedWith(){

    }

    @Around("binsAnnotatedWith() || methodsAnnotatedWith()")
    public Object loggableAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("target: {}", joinPoint.getTarget().getClass());
        try {
            Object returnValue = joinPoint.proceed();
            log.info("result: {}", returnValue);
            return returnValue;
        }catch (Throwable e){
            log.info("exception: {}", e.getMessage());
            throw e;
        }
    }
}
