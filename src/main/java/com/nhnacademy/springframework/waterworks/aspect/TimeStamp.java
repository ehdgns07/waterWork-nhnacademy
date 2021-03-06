package com.nhnacademy.springframework.waterworks.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeStamp {
    static final Log log = LogFactory.getLog(TimeStamp.class);

    @Around("execution( public * read(..))")
    public Object csvFilereadTimeStamp(ProceedingJoinPoint pjp) throws Throwable {
        return stopWatch(pjp);
    }

    @Around("execution( public * dataReadAndSave(..))")
    public Object dataReadTimeStamp(ProceedingJoinPoint pjp) throws Throwable {
        return stopWatch(pjp);

    }

    @Around("execution( public * calculator(..))")
    public Object calculatorTimeStamp(ProceedingJoinPoint pjp) throws Throwable {
        return stopWatch(pjp);

    }

    @Around("execution( public * printingResult(..))")
    public Object printingTimeStamp(ProceedingJoinPoint pjp) throws Throwable {
        return stopWatch(pjp);
    }

    private Object stopWatch(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info(pjp.toShortString());
            log.info(stopWatch.prettyPrint());
        }
    }
}
