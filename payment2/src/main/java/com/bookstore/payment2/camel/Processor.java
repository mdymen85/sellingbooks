package com.bookstore.payment2.camel;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Consume;
import org.apache.camel.ConsumerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class Processor {

    private final ConsumerTemplate consumerTemplate;

//    @Consume("spring-rabbitmq:x2")
//    public void process2(String x) {
//        log.info("==> {}", x);
//    }

    public void process() throws IOException {



//        channel.queueDeclare("x2", true, false, false, null);
//
//        DefaultConsumer consumer = new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(
//                    String consumerTag,
//                    Envelope envelope,
//                    AMQP.BasicProperties properties,
//                    byte[] body) throws IOException {
//
//                String message = new String(body, "UTF-8");
//                log.info("Pro -> {}", message);
//            }
//        };
//        channel.basicConsume("products_queue", true, consumer);
//
//
//        var received = consumerTemplate.receiveBody("spring-rabbitmq:amq.fanout", String.class);
//
//        log.info("Received ----> {}", received);
    }



}
