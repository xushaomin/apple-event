package com.appleframework.event.factory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.appleframework.event.ObjectEvent;
import com.appleframework.event.ObjectEventHandler;
import com.lmax.disruptor.LiteBlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class DisruptorFactory {

	private static Disruptor<ObjectEvent> disruptor;

	private static ObjectEventHandler eventHandler;
	
	private static int bufferSize = 1024;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Disruptor<ObjectEvent> getInstance() {
		if (disruptor == null) {
			Executor executor = Executors.newCachedThreadPool();
			disruptor = new Disruptor<>(ObjectEvent::new, bufferSize, executor, ProducerType.SINGLE,
					new LiteBlockingWaitStrategy());
			disruptor.handleEventsWith(eventHandler);
			disruptor.start();
		}
		return disruptor;
	}
	
	public static void setEventHandler(ObjectEventHandler eventHandler) {
		DisruptorFactory.eventHandler = eventHandler;
	}

	public static void destroy() {
		DisruptorFactory.disruptor.shutdown();
	}

	public static void setBufferSize(int bufferSize) {
		DisruptorFactory.bufferSize = bufferSize;
	}

}
