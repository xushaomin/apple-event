package com.appleframework.event;

import com.appleframework.event.factory.DisruptorFactory;

public class AppTest {
	
	public static void main(String[] args) {
		TestHandler handler = new TestHandler();
		DisruptorFactory.setEventHandler(handler);
		
		for (int i = 0; i < 10000; i++) {
			EventPublisher.publishEvent(i + "");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
