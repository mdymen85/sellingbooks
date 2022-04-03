package com.bookstore.payment1.service;

import com.bookstore.payment1.domain.Author;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQAuthor extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Author.class);

//        from("timer:foo?period=1000000").routeId("idOfQueueHere").setBody()
//                .constant("{\"x\":\"xxxx\"}")
//                .log("Trying...")
//                .to("spring-rabbitmq:amq.fanout")
//                .log("Message sent:");

        from("direct:startQueuePoint").id("idOfQueueHere").marshal(jsonDataFormat)
                .to("spring-rabbitmq:amq.fanout").end();

    }


}
