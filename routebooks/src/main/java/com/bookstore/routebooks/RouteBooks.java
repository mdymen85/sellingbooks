package com.bookstore.routebooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
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
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        LinkedHashMap outbox = (LinkedHashMap) exchange.getIn().getBody();
                        var uuid = outbox.get("uuid");
                        log.info("outbox {}",uuid);
                        var mapOutbox = new HashMap<String, String>();
                        mapOutbox.put("uuid", uuid.toString());
                        exchange.getIn().setBody(uuid);
                    }
                })
                .log("log ${body}")
                .to("sql:delete from sb_outbox where uuid = :#${body}")
                .marshal().json(JsonLibrary.Jackson)
                .to("spring-rabbitmq:amq.fanout")
                .end();

    }
}
