package com.bookstore.routebooks;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteBooks extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:foo?period=1000")
//                .setHeader("lic", constant("ASF"))
//                .setHeader("min", constant(123))
                .setBody(constant("select * from sb_author"))
                .to("jdbc:datasource")
                .split(body()).streaming()
                .marshal()
                .json(JsonLibrary.Jackson)
                .to("spring-rabbitmq:amq.fanout");//.end();

    }
}
