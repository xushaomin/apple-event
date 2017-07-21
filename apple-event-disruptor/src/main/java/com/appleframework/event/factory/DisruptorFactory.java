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

	private static ObjectEventHandler objectEventHandler;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Disruptor<ObjectEvent> getInstance() {
		if (disruptor == null) {
			Executor executor = Executors.newCachedThreadPool();
			int bufferSize = 1024;
			disruptor = new Disruptor<>(ObjectEvent::new, bufferSize, executor, ProducerType.SINGLE,
					new LiteBlockingWaitStrategy());
			disruptor.handleEventsWith(objectEventHandler);
			disruptor.start();
		}
		return disruptor;
	}

	public static void setObjectEventHandler(ObjectEventHandler objectEventHandler) {
		DisruptorFactory.objectEventHandler = objectEventHandler;
	}
	
	public static void destroy() {
		DisruptorFactory.disruptor.shutdown();
	}

}
