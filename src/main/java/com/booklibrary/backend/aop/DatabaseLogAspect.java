package com.booklibrary.backend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseLogAspect {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Around("com.booklibrary.backend.aop.AppExpressions.forServicePackage()")
  public Object logDatabaseUsage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    String method = proceedingJoinPoint.getSignature().toShortString();

    logger.info("Performing CRUD operation - " + method);

    Object result = null;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (RuntimeException exc) {
      logger.error(exc.getMessage());
    }

    return result;
  }
}
