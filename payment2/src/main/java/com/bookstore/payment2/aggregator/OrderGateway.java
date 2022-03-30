package com.bookstore.payment2.aggregator;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@MessagingGateway
public interface OrderGateway {
	
	@Gateway(requestChannel = "channelTest")
	public void process(Message<Order> message);
}
