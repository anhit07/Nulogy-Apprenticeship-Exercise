package com.anh.spring.nupack.utilities;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class PropertiesUtil {

	private Environment environment;

	@SuppressWarnings("resource")
	public PropertiesUtil() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PropertiesBean.class);
		context.registerShutdownHook();
		this.environment = context.getBean(Environment.class);
	}
	
	public String getPropertyValue(String propertyName){
		return environment.getProperty(propertyName);
	}
}
