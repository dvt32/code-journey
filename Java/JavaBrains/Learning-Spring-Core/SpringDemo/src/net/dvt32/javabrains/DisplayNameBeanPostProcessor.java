package net.dvt32.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor
	implements BeanPostProcessor
{
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
		throws BeansException
	{
		System.out.println("In AfterInitialization method. Bean name is " + beanName);
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
		throws BeansException
	{
		System.out.println("In BeforeInitialization method. Bean name is " + beanName);
		return bean;
	}
}
