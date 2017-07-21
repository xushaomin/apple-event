package com.appleframework.event;

import com.lmax.disruptor.EventHandler;

public abstract class ObjectEventHandler implements EventHandler<ObjectEvent> {

	@Override
	public void onEvent(ObjectEvent event, long sequence, boolean endOfBatch) throws Exception {
		onEvent(event);
	}
	
	public abstract void onEvent(ObjectEvent event);
}