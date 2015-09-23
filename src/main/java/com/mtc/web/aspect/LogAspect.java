package com.mtc.web.aspect;


import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect
public class LogAspect {
	
	private Logger logger = Logger.getLogger(LogAspect.class);
	
	@AfterThrowing(pointcut="execution(public * com.mtc.web.controller.RegisterController.*(..))",throwing="sqlException")
	public void logExceptionMethod(JoinPoint joinPoint, SQLException sqlException){
		logger.info("*****SQLException"+joinPoint.toShortString()+"**************");
		
	}
	
	@Around("execution(public * com.mtc.web.controller.RegisterController.*(..)) ")
	public Object logMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		logger.info("*****Before"+proceedingJoinPoint.toShortString()+"**************");
	//
		Object returnValue= proceedingJoinPoint.proceed();
		logger.info("*****After"+proceedingJoinPoint.toShortString()+"**************");
		return returnValue;
		
	}
	
//@Before("execution(public * com.mtc.web.controller.RegisterController.*(..)) ")	
// public void logBeforeMethod(JoinPoint joinpoint){
//	 logger.info("*****Before"+joinpoint.toShortString()+"**************");
//	 Object[] arguments =joinpoint.getArgs();
//	 Object object=joinpoint.getTarget();
// }
//
//@AfterReturning("execution(public * com.mtc.web.controller.RegisterController.*(..))")
//public void logAfterMethod(JoinPoint joinpoint){
//	 logger.info("*****After"+joinpoint.toShortString()+"**************");
//}
}
