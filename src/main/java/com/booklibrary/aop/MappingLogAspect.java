package com.booklibrary.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MappingLogAspect {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Around("com.booklibrary.aop.AppExpressions.forMapperPackage()")
  public Object logMappingUsage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    String method = proceedingJoinPoint.getSignature().toShortString();

    logger.info("Mapping the object - " + method);

    Object result = null;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (RuntimeException exc) {
      logger.error(exc.getMessage());
    }

    return result;
  }
}
