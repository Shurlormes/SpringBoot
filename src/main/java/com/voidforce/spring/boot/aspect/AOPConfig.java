package com.voidforce.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOPConfig {

	private final static Logger log = LoggerFactory.getLogger(AOPConfig.class);

	@Around("@within(org.springframework.stereotype.Controller)")
	public Object aroundAop(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		log.info("Args: {}", Arrays.asList(args));
		Object o = pjp.proceed();
		log.info("Return: {}", o);
		return o;
	}

}
