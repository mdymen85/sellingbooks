package com.bookstore.payment2.aggregator;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

@MessageEndpoint
public class MethodAggregator {

	@Aggregator(inputChannel = "channelTest", outputChannel = "outputTests", sendTimeout = "1000")
	public List<Order> process(List<Message<Order>> messages) {
		return messages.stream().map(message -> message.getPayload())
				.map(order -> (Order) order)
				.collect(Collectors.toList());
	}
	
	@CorrelationStrategy
	public Integer correlation(Message<Order> message) {
		return (Integer) message.getHeaders().get("correlationId");
	}
	
//	@ReleaseStrategy
//	public boolean releaseStrategy(List<Message<Order>> list) {
//		return list.size() > 2;
//	}

	
}
