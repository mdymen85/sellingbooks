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
                .log("log ${in.headers.uuid}")
                .to("sql:delete from sb_outbox where uuid = :#uuid")
                .marshal().json(JsonLibrary.Jackson)
                .to("spring-rabbitmq:amq.fanout")
                .end();

    }
}

class ProcessQuery implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        LinkedHashMap outbox = (LinkedHashMap) exchange.getIn().getBody();
        Map<String, Object> map = new HashMap<>() {{
          put("object_json", outbox.get("object_json"));
        }};
        exchange.getIn().setBody(outbox.get("object_json"));
        exchange.getIn().setHeader("uuid", outbox.get("uuid").toString());
        exchange.getIn().setHeader("object_json", outbox.get("object_json").toString());
    }
}
