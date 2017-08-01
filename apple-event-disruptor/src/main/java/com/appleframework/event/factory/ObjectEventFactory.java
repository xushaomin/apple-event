package com.appleframework.event.factory;

import com.appleframework.event.ObjectEvent;
import com.lmax.disruptor.EventFactory;

public class ObjectEventFactory implements EventFactory<ObjectEvent> {
	
	public ObjectEvent newInstance() {
		return new ObjectEvent();
	}
	
}