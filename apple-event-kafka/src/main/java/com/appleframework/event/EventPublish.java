package com.appleframework.event;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.appleframework.jms.core.producer.MessageProducer;

/**
 * 事件系统
 */

public class EventPublish {

	private static MessageProducer messageProducer = null;
	
	public static void setMessageProducer(MessageProducer messageProducer) {
		EventPublish.messageProducer = messageProducer;
	}

	public static void publishEvent(ApplicationEvent event) {
		messageProducer.sendObject(event);
	}
	
	public static void publishEvent(Object event) {
		messageProducer.sendObject((Serializable)event);
	}

}