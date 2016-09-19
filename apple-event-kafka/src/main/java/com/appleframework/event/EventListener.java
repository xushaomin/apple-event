package com.appleframework.event;

import org.springframework.context.ApplicationEvent;

import com.appleframework.jms.kafka.consumer.ObjectMessageConsumer;

/**
 * 事件系统
 */

public class EventListener extends ObjectMessageConsumer {

	@Override
	public void processMessage(Object message) {
		if(message instanceof ApplicationEvent) {
			ApplicationEvent event = (ApplicationEvent) message;
			EventHandler.publishEvent(event);
		}
		else {
			EventHandler.publishEvent(message);
		}
	}

}