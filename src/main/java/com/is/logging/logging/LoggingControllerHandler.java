package com.is.logging.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingControllerHandler extends LoggingHandlerAbstract {


    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Pointcut("within(com.is..*)")
    public void onlyProject() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    //Around -> Any method within resource annotated with @Controller annotation
    @Around("controller() && allMethod() && onlyProject()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return super.logAround(joinPoint);
    }
}
