package com.test.aspect;


import org.aspectj.lang.JoinPoint;

public class SimpleExceptionLogger {

    public void logException(JoinPoint joinPoint, Throwable t){
        System.out.println("ASPECT.EXCEPTION-LOGGER: " + t.getMessage());
    }
}
