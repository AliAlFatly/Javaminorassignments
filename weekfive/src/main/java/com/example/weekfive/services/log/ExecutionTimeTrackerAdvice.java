package com.example.weekfive.services.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    Logger logger = LoggerFactory.getLogger((ExecutionTimeTrackerAdvice.class));

    @Around("@annotation(com.example.weekfive.services.log.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("EXECUTE " + proceedingJoinPoint.getClass() + "." + proceedingJoinPoint.getSignature().getName() + "()" + " execution time is: " + (endTime - startTime));

        return obj;
    }


}
