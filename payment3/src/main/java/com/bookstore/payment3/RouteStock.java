package com.bookstore.payment3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RouteStock extends RouteBuilder {

    private final ObjectMapper mapper;

    @Override
    public void configure() throws Exception {

        from("rabbitmq:amq.direct?queue=stock-queue&autoDelete=false")
                .unmarshal().json(JsonLibrary.Jackson)
                .process(new StockProcessor(mapper))
                .split(body())
                .streaming()
                .to("jpa:com.bookstore.payment3.Book")
                .end();

    }
}