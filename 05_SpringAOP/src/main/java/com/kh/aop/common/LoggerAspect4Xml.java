package com.kh.aop.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect4Xml {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAspect4Xml.class);
	
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.debug("선언적 AOP 처리 방식입니다!");
		
		//joinPoint.proceed()메소드는 Throwable을 던진다.
        Signature signature = joinPoint.getSignature();
        // logger.debug("signature="+signature);
        // ModelAndView com.kh.aop.memo.controller.MemoController.memo()
        
        String type = signature.getDeclaringTypeName();	
        String methodName = signature.getName();
        // logger.debug("type="+type);//com.kh.aop.memo.controller.MemoController
        // logger.debug("methodName="+methodName);//memo등 각 타겟객체의 메소드
        
        String componentName = "";
        if (type.indexOf("Controller") > -1) {
            componentName = "Controller  \t:  ";
        }
        else if (type.indexOf("Service") > -1) {
            componentName = "ServiceImpl  \t:  ";
        }
        else if (type.indexOf("DAO") > -1) {
            componentName = "DAO  \t\t:  ";
        }
        
        logger.debug("[수행 전] : " + componentName + " / " + type + " / " + methodName);
		
        Object obj = joinPoint.proceed();
        
        logger.debug("[수행 후] : " + componentName + " / " + type + " / " + methodName);
		
        return obj;
	}

}
