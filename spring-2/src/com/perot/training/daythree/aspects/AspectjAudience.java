/**
 * 
 */
package com.perot.training.daythree.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author abrahade
 */
@Aspect
public class AspectjAudience {
    
    private static final Log logger = LogFactory.getLog(AspectjAudience.class);
    
    @Pointcut("execution (* *.perform(..))")
    public void performance() {
    }

    //@Before("performance()")
    public void takeSeats() {
        logger.info("Audience is Taking seats");
    }
    
    //@Before("performance()")
    public void turnOffCellPhones() {
        logger.info("Audience Turning of cells");
    }

    //@AfterReturning("performance()")
    public void applaud() {
        logger.info("Audience is appalauding");
    }
    
    //@AfterThrowing("performance()")
    public void demandRefund() {
        logger.info("Boo!. Audience wants money back!!");
    }
    
    /**
     * Add annotation to this or to above three but not both
     * @param joinPoint
     * @throws Throwable
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        takeSeats();
        turnOffCellPhones();
        
        try {
            joinPoint.proceed();
            applaud();
        } catch (PerformanceException e) {
           demandRefund();
        }
        
        
    }

}
