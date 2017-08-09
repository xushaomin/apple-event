package com.appleframework.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件系统
 */

public interface IEventPublisher {

	public void publishApplicationEvent(ApplicationEvent event);
	
	public void publishObjectEvent(Object event);

}