package com.appleframework.event;

import org.springframework.context.ApplicationEvent;

import com.appleframework.event.factory.DisruptorFactory;
import com.lmax.disruptor.RingBuffer;

/**
 * 事件系统
 */
public class EventPublisher implements IEventPublisher {

	@Override
	public void publish(ApplicationEvent event) {
		publishEvent(event);
	}

	@Override
	public void publish(Object event) {
		publishEvent((Object) event);
	}

	public static void publishEvent(ApplicationEvent object) {
		publishEvent((Object) object);
	}

	public static void publishEvent(Object object) {
		RingBuffer<ObjectEvent> ringBuffer = DisruptorFactory.getInstance().getRingBuffer();
		long sequence = ringBuffer.next(); // 申请位置
		try {
			ObjectEvent event = ringBuffer.get(sequence);
			event.setObject(object); // 放置数据
		} finally {
			ringBuffer.publish(sequence); // 提交，如果不提交完成事件会一直阻塞
		}
	}

}