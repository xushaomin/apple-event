package com.appleframework.event;

public class ObjectEvent {

	private Object object;

	public ObjectEvent() {}

	public ObjectEvent(Object object) {
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public ObjectEvent setObject(Object object) {
		this.object = object;
		return this;
	}

}
