package com.appleframework.event;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.appleframework.jms.core.producer.MessageProducer3;

/**
 * 事件系统
 */
public class EventPublisher2 implements IEventPublisher2 {

	private static MessageProducer3 messageProducer = null;

	public void setMessageProducer(MessageProducer3 messageProducer) {
		EventPublisher2.messageProducer = messageProducer;
	}

	public static void publishEvent(String topic, ApplicationEvent event) {
		messageProducer.sendObject(topic, event.getClass().getName(), event);
	}
	
	public static void publishEvent(String topic, ApplicationEvent event, String key) {
		messageProducer.sendObject(topic, key, event);
	}

	public static void publishEvent(String topic, Object event) {
		messageProducer.sendObject(topic, event.getClass().getName(), (Serializable) event);
	}
	
	public static void publishEvent(String topic, Object event, String key) {
		messageProducer.sendObject(topic, key, (Serializable) event);
	}

	@Override
	public void publish(String topic, ApplicationEvent event) {
		messageProducer.sendObject(topic, event.getClass().getName(), event);
	}
	
	public void publish(String topic, ApplicationEvent event, String key) {
		messageProducer.sendObject(topic, key, event);
	}

	@Override
	public void publish(String topic, Object event) {
		messageProducer.sendObject(topic, event.getClass().getName(), (Serializable) event);
	}
	
	public void publish(String topic, Object event, String key) {
		messageProducer.sendObject(topic, key, (Serializable) event);
	}

}