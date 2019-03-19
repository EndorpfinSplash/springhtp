package com.htp.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Before("execution(public * *(..))")
    public void logBefore(JoinPoint joinPoint) {
//        LOGGER.info("logBefore() is running!");
//        LOGGER.info("Method " + joinPoint.getSignature().getName() + " start");
        System.out.println("logBefore() is running!");
        System.out.println("Method " + joinPoint.getSignature().getName() + " start");
    }

    @AfterReturning(pointcut = "execution(public * *(..))")
    public void doAccessCheck(JoinPoint joinPoint) {
        LOGGER.info("logAfterReturning() is running!");
        LOGGER.info("Method " + joinPoint.getSignature().getName() + " finished");

        System.out.println("logAfterReturning() is running!");
        System.out.println("Method " + joinPoint.getSignature().getName() + " finished");
    }
}