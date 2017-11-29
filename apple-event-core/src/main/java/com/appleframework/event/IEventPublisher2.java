package com.appleframework.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件系统
 */

public interface IEventPublisher2 {

	public void publish(String topic, ApplicationEvent event);
	
	public void publish(String topic, Object event);

}