package net.dvt32.spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* net.dvt32.spring.aop.data.*.*(..))")
	public void dataLayerExecution() { }
	
	@Pointcut("execution(* net.dvt32.spring.aop.business.*.*(..))")
	public void businessLayerExecution() { }
	
	@Pointcut("net.dvt32.spring.aop.aspect.CommonJoinPointConfig.dataLayerExecution() && net.dvt32.spring.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void allLayerExecution() { }
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() { }
	
	@Pointcut("within(net.dvt32.spring.aop.data..*)")
	public void dataLayerExecutionWithWithin() { }
	
	@Pointcut("@annotation(net.dvt32.spring.aop.aspect.TrackTime)")
	public void trackTimeAnnotation() {
	
	}
}
