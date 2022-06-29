package com.bookstore.payment3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class StockProcessor implements Processor {

    private final ObjectMapper mapper;

    @Override
    public void process(Exchange exchange) throws Exception {

        var booksMessage = exchange.getIn().getBody().toString();

        var jsonNodes = mapper.readTree(booksMessage);

        var booksList = (ArrayNode) jsonNodes.get("books");

        var authorName = jsonNodes.get("name").asText();
        var authorUuid = jsonNodes.get("uuid").asText();

        List<Book> books = new ArrayList<Book>();

        for (JsonNode node : booksList) {
            var book = Book.builder()
                                .authorUuid(authorUuid)
                                .bookName(node.get("name").asText())
                                .authorName(authorName)
                                .bookUuid(node.get("uuid").asText())
                                .stock(node.get("stock").asLong())
                                .build();

            books.add(book);
        }

        //exchange.

        log.info("dados {}", books);

        exchange.getIn().setBody(books);

    }
}
