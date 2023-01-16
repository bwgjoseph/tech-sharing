package com.bwgjoseph.springbootmvc.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    // Type of Advice: `before, after, after return, after throw, around`
    // can target any class, method, annotation
    @Around("@annotation(LoggingAop)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
      Long start = System.currentTimeMillis();
      log.info("[aop] start log: {}", pjp.toString());
      Thread.sleep(1000, 0);
      Object proceed = pjp.proceed();
      log.info("[aop] end log: {}", pjp.toString());
      Long end = System.currentTimeMillis();

      log.info("[aop] took: {}", end - start);

      return proceed;
    }
}
