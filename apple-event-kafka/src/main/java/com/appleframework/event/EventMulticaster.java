package com.appleframework.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * 事件系统
 */

public class EventMulticaster implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		EventMulticaster.applicationContext = applicationContext;
	}
	
	public void destroy() throws Exception {
		applicationContext = null;
	}

	public static void publishEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);;
	}
	
	public static void publishEvent(Object event) {
		applicationContext.publishEvent(event);;
	}

}