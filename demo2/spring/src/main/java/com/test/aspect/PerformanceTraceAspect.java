package com.test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;

/**
 * Created by zhang_minzhong on 2017/7/8.
 */
@Aspect
public class PerformanceTraceAspect {
    private final Log logger = LogFactory.getLog(PerformanceTraceAspect.class);

    @Pointcut("execution(public void *.method1())||execution(public void *.method2()))")
    public void pointcutName(){};

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            System.out.println("123");
            watch.start();
            return joinPoint.proceed();
        }finally {
            System.out.println("456");
            watch.stop();
            if(logger.isInfoEnabled())
                logger.info("PT in method["+joinPoint.getSignature().getName()+"]>>>>>"+watch.toString());
        }
    }
    /*@After("pointcutName()")
    public void clean(){
        System.out.println("123");
    }*/
    @AfterReturning(pointcut = "execution(public int *.method3())",returning = "retValue")
    public void taskCompleted(int retValue){
        System.out.println(retValue);
    }
}
