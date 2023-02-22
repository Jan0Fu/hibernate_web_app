package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}
    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage() {}
    @Pointcut("execution(* com.springdemo.repository.*.*(..))")
    private void forRepositoryPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before: calling method: " + method);
    }

}
