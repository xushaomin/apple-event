package com.appleframework.event;

public class TestHandler extends ObjectEventHandler {

	@Override
	public void onEvent(ObjectEvent event) {
		System.out.println(event.getObject());
	}
}
