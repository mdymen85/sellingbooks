package com.bookstore.payment2.camel;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.bookstore.payment2.DynamoDBTables;
import com.bookstore.payment2.model.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.aws2.ddb.Ddb2Constants;
import org.apache.camel.component.aws2.ddb.Ddb2Operations;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQAuthor extends EndpointRouteBuilder {

    @Value("${rabbitmq.queue.name:outbox-testing-queue}")
    private String queue;

    private final AmazonDynamoDB dynamoDb;
    private final ObjectMapper mapper;
    private final DynamoDBTables tables;

    @Override
    public void configure() throws Exception {

        tables.createDynamoDBTables();

        from("rabbitmq:amq.direct?queue=outbox-testing-queue&autoDelete=false")
                .unmarshal().json(JsonLibrary.Jackson)
                .process(new ProcessRabbitMQAuthor(mapper))
                .log("log ${body}")
                .to("aws2-ddb://Author?overrideEndpoint=true&uriEndpointOverride=http://localhost:8000&readCapacity=1&writeCapacity=1&useDefaultCredentialsProvider=true")
                .end();
//                .to("aws2-ddb://Author?keyAttributeName=uuid&keyAttributeType=" + KeyType.HASH
//                + "&keyScalarType=" + ScalarAttributeType.S
//                + "&readCapacity=1&writeCapacity=1&useDefaultCredentialsProvider=true");
    }

}

@RequiredArgsConstructor
class ProcessRabbitMQAuthor implements Processor {

    private final ObjectMapper mapper;

    @Override
    public void process(Exchange exchange) throws Exception {
        var authorString = exchange.getIn().getBody(String.class);
        var author = mapper.readValue(authorString, Author.class);
        var books = mapper.writeValueAsString(author.getBooks());

        Map<String, AttributeValue> map = new HashMap<String, AttributeValue>() {{
            put("uuid", AttributeValue.builder().s(author.getUuid().toString()).build());
            put("name", AttributeValue.builder().s(author.getName().toString()).build());
            put("books", AttributeValue.builder().s(books.toString()).build());
        }};

        exchange.getIn().setBody(map);
        exchange.getIn().setHeader("CamelAwsDdbAttributes", map);
        exchange.getIn().setHeader("CamelAwsDdbItems", map);
        exchange.getIn().setHeader("CamelAwsDdbItem", map);

       // exchange.getIn().setHeader("item", mapItens);
//        exchange.getIn().setHeader(Ddb2Constants.ATTRIBUTE_NAMES, map.keySet());
//        exchange.getIn().setHeader(Ddb2Constants.OPERATION, Ddb2Operations.PutItem);

    }
}
