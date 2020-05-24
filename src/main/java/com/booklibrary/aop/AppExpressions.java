package com.booklibrary.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AppExpressions {

  @Pointcut("execution(* com.booklibrary.service.*.saveOrUpdate(..))")
  public void saveFromService() {}

  @Pointcut("execution(* com.booklibrary.service.*.get*(..))")
  public void getFromService() {}

  @Pointcut("execution(* com.booklibrary.service.*.delete*(..))")
  public void deleteFromService() {}

  @Pointcut("execution(* com.booklibrary.controller.*.get*(..))")
  public void getFromController() {}

  @Pointcut("execution(* com.booklibrary.controller.*.create*(..))")
  public void createFromController() {}

  @Pointcut("execution(* com.booklibrary.controller.*.update*(..))")
  public void updateFromController() {}

  @Pointcut("execution(* com.booklibrary.controller.*.delete*(..))")
  public void deleteFromController() {}

  @Pointcut("execution(* com.booklibrary.mapper.*.mapTo*Dto(..))")
  public void mapToDto() {}

  @Pointcut("execution(* com.booklibrary.mapper.*.mapTo*DtoList(..))")
  public void mapToDtoList() {}

  @Pointcut("execution(* com.booklibrary.mapper.*.mapTo*(..))")
  public void mapTo() {}

  @Pointcut(
      "mapToDto() || mapToDtoList() || mapTo()")
  public void forMapperPackage() {}

  @Pointcut("saveFromService() || getFromService() || deleteFromService()")
  public void forServicePackage() {}

  @Pointcut(
      "createFromController() || getFromController() || updateFromController() || deleteFromController()")
  public void forControllerPackage() {}
}
