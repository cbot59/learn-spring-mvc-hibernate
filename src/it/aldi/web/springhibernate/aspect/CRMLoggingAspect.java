package it.aldi.web.springhibernate.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

  private final Logger LOG = Logger.getLogger(getClass().getName());

  // Any class and method on controller package
  @Pointcut("execution (* it.aldi.web.springhibernate.controller.*.*(..))")
  private void forControllerPackage() {}

  //Any class and method on service package
  @Pointcut("execution (* it.aldi.web.springhibernate.service.*.*(..))")
  private void forServicePackage() {}

  //Any class and method on dao package
  @Pointcut("execution (* it.aldi.web.springhibernate.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("forControllerPackage() || forServicePackage() ||  forDaoPackage()")
  private void forAppFlow() {}

  @Before("forAppFlow")
  public void before(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().toShortString();
    LOG.info("===> Calling @Before from method" + method);

    Object[] args = joinPoint.getArgs();

    for (Object arg : args) {
      LOG.info("===> arguments: " + arg);
    }
  }

  @AfterReturning(pointcut = "forAppFlow", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {

    String method = joinPoint.getSignature().toShortString();
    LOG.info("===> Calling @AfterReturning from method " + method);
    LOG.info("===> result: " + result);
  }
}
