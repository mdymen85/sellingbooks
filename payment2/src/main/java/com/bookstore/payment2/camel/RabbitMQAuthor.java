package com.bookstore.payment2.camel;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.aws2.ddb.Ddb2Constants;
import org.apache.camel.component.aws2.ddb.Ddb2Operations;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQAuthor extends EndpointRouteBuilder {

    @Value("${rabbitmq.queue.name:outbox-testing-queue}")
    private String queue;

    private final AmazonDynamoDB dynamoDb;

    @Override
    public void configure() throws Exception {

        from("rabbitmq:amq.direct?queue=outbox-testing-queue&autoDelete=false")
                .unmarshal().json(JsonLibrary.Jackson)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        var ob = exchange.getIn().getBody();
                        Map<String, AttributeValue> map = new HashMap<String, AttributeValue>() {{
                            put("uuid", AttributeValue.builder().s(ob.toString()).build() );
                        }};
                        exchange.getIn().setHeader("CamelAwsDdbItem", map);
                    }
                })
                .log("log ${body}")
                .to("aws2-ddb://Author?keyAttributeName=uuid&keyAttributeType=" + KeyType.HASH
                + "&keyScalarType=" + ScalarAttributeType.S
                + "&readCapacity=1&writeCapacity=1&useDefaultCredentialsProvider=true");
    }

}
