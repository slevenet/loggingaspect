package com.is.logging.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public abstract class LoggingHandlerAbstract {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Optional<Object> principal =  Arrays.stream(joinPoint.getArgs())
                    .filter(arg -> arg instanceof Principal)
                    .findFirst();
            log.info("Start controller: " + className);
            log.info("Time : " + LocalDateTime.now());
            principal.ifPresent(user -> log.info("UserName: " + ((Principal) user).getName()));
            log.info("Method : " + className + "." + methodName);
            Object result = joinPoint.proceed();
            log.info("End controller : " + className);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName());
            throw e;
        }
    }

}
