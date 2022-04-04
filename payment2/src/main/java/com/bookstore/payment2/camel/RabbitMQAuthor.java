package com.bookstore.payment2.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQAuthor extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("rabbitmq:amq.direct?queue=x2&autoDelete=false").log("log ${body}");

    }


}
