package com.appleframework.event.factory;

import org.springframework.beans.factory.FactoryBean;

import com.appleframework.event.ObjectEvent;
import com.appleframework.event.ObjectEventHandler;
import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorFactoryBean implements FactoryBean<Disruptor<ObjectEvent>> {

	@Override
	public Disruptor<ObjectEvent> getObject() throws Exception {
		return DisruptorFactory.getInstance();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class<Disruptor> getObjectType() {
		return Disruptor.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void setObjectEventHandler(ObjectEventHandler objectEventHandler) {
		DisruptorFactory.setObjectEventHandler(objectEventHandler);
	}

	public void destroy() {
		DisruptorFactory.destroy();
	}

}
