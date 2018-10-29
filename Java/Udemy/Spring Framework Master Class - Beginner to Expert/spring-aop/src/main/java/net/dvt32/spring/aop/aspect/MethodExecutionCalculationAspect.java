package net.dvt32.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(
		value = "net.dvt32.spring.aop.aspect.CommonJoinPointConfig.businessLayerExecution()",
		returning = "result"
	)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@After(value = "net.dvt32.spring.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
}
