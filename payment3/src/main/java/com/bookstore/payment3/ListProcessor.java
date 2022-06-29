package com.bookstore.payment3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ListProcessor implements Processor {

    private final ObjectMapper objectMapper;

    @Override
    public void process(Exchange exchange) throws Exception {

        var valor = exchange.getIn().getBody();

        log.info("valor {}", valor);

    }

}
