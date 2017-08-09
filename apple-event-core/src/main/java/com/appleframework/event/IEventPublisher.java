package com.appleframework.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件系统
 */

public interface IEventPublisher {

	public void publish(ApplicationEvent event);
	
	public void publish(Object event);

}