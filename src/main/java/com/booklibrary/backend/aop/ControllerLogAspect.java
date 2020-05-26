package com.booklibrary.backend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogAspect {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Around("com.booklibrary.backend.aop.AppExpressions.forControllerPackage()")
  public Object logControllerUsage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    String method = proceedingJoinPoint.getSignature().toShortString();

    logger.info("Using REST controller - " + method);

    Object result = null;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (RuntimeException exc) {
      logger.error(exc.getMessage());
    }

    return result;
  }
}
