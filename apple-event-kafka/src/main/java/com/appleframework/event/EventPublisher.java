package com.appleframework.event;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.appleframework.jms.core.producer.MessageProducer3;

/**
 * 事件系统
 */
public class EventPublisher implements IEventPublisher {

	private static MessageProducer3 messageProducer = null;
	private static String topic;

	public void setMessageProducer(MessageProducer3 messageProducer) {
		EventPublisher.messageProducer = messageProducer;
	}

	public void setTopic(String topic) {
		EventPublisher.topic = topic;
	}

	public static void publishEvent(ApplicationEvent event) {
		messageProducer.sendObject(topic, event.getClass().getName(), event);
	}

	public static void publishEvent(Object event) {
		messageProducer.sendObject(topic, event.getClass().getName(), (Serializable) event);
	}

	@Override
	public void publish(ApplicationEvent event) {
		messageProducer.sendObject(topic, event.getClass().getName(), event);
	}

	@Override
	public void publish(Object event) {
		messageProducer.sendObject(topic, event.getClass().getName(), (Serializable) event);
	}

}