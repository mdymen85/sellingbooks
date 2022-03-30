package com.bookstore.payment2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import com.bookstore.payment2.aggregator.MethodAggregator;
import com.bookstore.payment2.aggregator.Order;
import com.bookstore.payment2.aggregator.OrderGateway;

@SpringBootTest
public class OrderAggregatorTest {
	
	@Autowired
	private OrderGateway paygate;
	
	@Autowired
	@Qualifier("channelTest")
	private MessageChannel messageChannel;
	
	@Autowired
	private MethodAggregator methodAggregator;
	
	@Test
	public void teste11() throws InterruptedException {
        Order p1 = new Order("SINGLE", 11);
        Order p2 = new Order("RECURRING", 25);
        Order p3 = new Order("SINGLE", 32);
        Order p4 = new Order("RECURRING", 15);
        Order p5 = new Order("MARMOTA", 75);
        Order p6 = new Order("TRACAA", 35);
        Order p7 = new Order("CACACA", 332);
        Order p8 = new Order("erwr", 332);
        Order p9 = new Order("CA5ertgeCACA", 332);
        
        
        Map<String, Integer> headers1 = new HashMap<>();
        headers1.put("correlationId", 1);
        
        Map<String, Integer> headers2 = new HashMap<>();
        headers2.put("correlationId", 2);
        
        Map<String, Integer> headers3 = new HashMap<>();
        headers3.put("correlationId", 3);
        
        Message mp1 = new GenericMessage(p1, headers1);
        
        Thread.sleep(1000);
        
        Message mp2 = new GenericMessage(p6, headers1);
        Message mp3 = new GenericMessage(p5, headers1);
        Message mp4 = new GenericMessage(p4, headers2);
        
        Thread.sleep(1000);
        
        Message mp5 = new GenericMessage(p3, headers2);
        Message mp6 = new GenericMessage(p2, headers2);
        Message mp7 = new GenericMessage(p7, headers2);
        Message mp8 = new GenericMessage(p8, headers2);
        
        Thread.sleep(1000);
        
        Message mp9 = new GenericMessage(p9, headers3);
//        
//        paygate.process(mp1);
//        paygate.process(mp2);
//        paygate.process(mp3);
//        paygate.process(mp4);
//        paygate.process(mp5);
//        paygate.process(mp6);
//        paygate.process(mp7);
        
//        paygate.
//        
       List<Message> lista = List.of(mp1, mp2, mp3, mp4, mp5, mp6);
       
//        
//        methodAggregator.process(lista);
//		
		this.messageChannel.send(mp1);
		this.messageChannel.send(mp2);
		this.messageChannel.send(mp3);
		this.messageChannel.send(mp4);
		this.messageChannel.send(mp5);
		this.messageChannel.send(mp6);
		this.messageChannel.send(mp7);
		this.messageChannel.send(mp8);
		this.messageChannel.send(mp9);
		this.messageChannel.send(mp1);
		this.messageChannel.send(mp2);
		this.messageChannel.send(mp3);
		this.messageChannel.send(mp4);
		
//		this.messageChannel.
	}
	
    @Test
    public void testOrderAggregator() {
//        Order p1 = new Order("SINGLE", 11);
//        Order p2 = new Order("RECURRING", 25);
//        Order p3 = new Order("SINGLE", 32);
//        Order p4 = new Order("RECURRING", 15);
//        QueueChannel orderChannel = new QueueChannel();
////        QueueChannel orderChannel = context.getBean("orderOutChannel", QueueChannel.class);
// 
//        Message mp1 = new GenericMessage(p1);
//        paygate.process(mp1);
//        Message<List> processedOrders = (Message<List>) orderChannel.receive(10000);
//        assertNull(processedOrders);
//        Message mp2 = new GenericMessage(p2);
//        Message mp3 = new GenericMessage(p3);
//        Message mp4 = new GenericMessage(p4);
// 
//        paygate.process(mp2);
//        paygate.process(mp3);
//        paygate.process(mp4);
//        processedOrders = (Message<List>) orderChannel.receive(60000);
//        verifyAggregOrderTypes(processedOrders);
 
    }
     
    private void verifyAggregOrderTypes(Message<List> reply) {
        // TODO Auto-generated method stub
        List orders = reply.getPayload();
        Order firstOrder = (Order) orders.get(0);
        for (int i = 1; i < orders.size(); i++) {
            assertEquals(firstOrder.getType(), ((Order) orders.get(i)).getType());
        }
    }
	 
	}   