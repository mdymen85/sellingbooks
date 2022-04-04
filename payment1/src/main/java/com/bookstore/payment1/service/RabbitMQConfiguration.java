package com.bookstore.payment1.service;

import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfiguration {

    private final CachingConnectionFactory rabbitConnectionFactory;

    @Bean
    public ConnectionFactory rabbitSourceConnectionFactory() {
        return rabbitConnectionFactory.getRabbitConnectionFactory();
    }

}
