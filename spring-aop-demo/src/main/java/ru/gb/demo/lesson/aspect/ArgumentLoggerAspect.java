package ru.gb.demo.lesson.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ArgumentLoggerAspect {

    //pointcut
    @Pointcut("execution(* ru.gb.demo.lesson.MyServiceBean.*(..))")
    public void MyServiceBeanMethodsPointcut(){

    }

    @Around("execution(* ru.gb.demo.lesson.MyServiceBean.Method1*(..))")
    public Object aroundServiceBeanMethodsPointcut(ProceedingJoinPoint joinPoint){
        try{
            Object proceed = joinPoint.proceed();
            log.info("proceed: " + proceed);
            return proceed;

        }catch (Throwable e){
            return "exception was thrown: [ " + e.getMessage() + "]";
        }
    }

    @Before("execution(* ru.gb.demo.lesson.MyServiceBean.Method1*(..))")
    public void beforeMyServiceBean(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        log.info("Signature: {}", signature);
        log.info("Argument name: {}", joinPoint.getArgs()[0]);
    }

    @AfterReturning(value = "execution(* ru.gb.demo.lesson.MyServiceBean.Method2*(..))", returning = "result")
    public void afterReturningMyServiceBean(JoinPoint joinPoint, Object result){
        log.info("Result: {}", result);
    }
}
