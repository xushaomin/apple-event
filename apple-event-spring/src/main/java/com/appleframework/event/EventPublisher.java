package com.appleframework.event;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * 事件系统
 */

public class EventPublisher implements IEventPublisher, ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext) {
		EventPublisher.applicationContext = applicationContext;
	}
	
	public void destroy() throws Exception {
		applicationContext = null;
	}

	public void publishApplicationEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);;
	}
	
	public void publishObjectEvent(Object event) {
		applicationContext.publishEvent(event);;
	}
	
	public static void publishEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);;
	}
	
	public static void publishEvent(Object event) {
		applicationContext.publishEvent(event);;
	}

}