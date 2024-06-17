package ru.gb.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.gb.timer.TimerProperties;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class TimerAspect {

  private final TimerProperties timerProperties;
  /**
   * within пишется под тип
   */
  @Pointcut("within(@ru.gb.aspect.Timer *)")
  public void beansAnnotatedWith() {
  }

  /**
   * annotation пишется под метод
   */
  @Pointcut("@annotation(ru.gb.aspect.Timer)")
  public void methodAnnotatedWith() {
  }

  @Around("beansAnnotatedWith() || methodAnnotatedWith()")
  public Object timerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
    final long start = System.currentTimeMillis();
    Object returnValue = null;
    try {
      returnValue = joinPoint.proceed();
      final long finish = System.currentTimeMillis();
      log.info(joinPoint.getTarget().getClass() + " - " + joinPoint.getSignature().getName() + " выполнение в секундах: #{}",
              (finish - start) / 1000);
      log.info("start: {} finish: {}", start, finish);
      log.info("className: {}", joinPoint.getTarget().getClass());
      log.info("methodName: {}", joinPoint.getSignature());
      return returnValue;
    } catch (Throwable ex) {
      log.info("Exception in timerAspect() {}", ex.getMessage());
      throw ex;
    }
  }
}
