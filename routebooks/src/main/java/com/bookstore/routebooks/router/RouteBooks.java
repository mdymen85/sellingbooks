package com.bookstore.routebooks.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RouteBooks extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:foo?period=1000")
                .setBody(constant("select uuid, object_json from sb_outbox"))
                .to("jdbc:datasource")
                .split(body()).streaming()
                .process(new ProcessQuery())
                .log("log ${body}")
                .to("sql:delete from sb_outbox where uuid = :#${body}")
                .marshal().json(JsonLibrary.Jackson)
                .to("spring-rabbitmq:amq.fanout")
                .end();

    }
}

class ProcessQuery implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        LinkedHashMap outbox = (LinkedHashMap) exchange.getIn().getBody();
        var uuid = outbox.get("uuid");
        exchange.getIn().setBody(uuid);
    }
}
