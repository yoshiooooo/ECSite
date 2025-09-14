package com.example.ecsite.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example..*(..))")
    public void logStart(JoinPoint joinPoint) {
        logger.info("START: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example..*(..))", returning = "result")
    public void logEnd(JoinPoint joinPoint, Object result) {
        logger.info("END: " + joinPoint.getSignature() + " Result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example..*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        logger.error("ERROR: " + joinPoint.getSignature(), ex);
    }
}
