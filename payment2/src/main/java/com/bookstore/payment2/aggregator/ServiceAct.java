package com.bookstore.payment2.aggregator;

import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceAct {

	@ServiceActivator(inputChannel = "outputTests", outputChannel = "sadfsd") 
	public void ppp(Message message) {
		System.out.println(message.getPayload());
	}
	
}
