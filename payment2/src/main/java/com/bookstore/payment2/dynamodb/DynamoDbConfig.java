package com.bookstore.payment2.dynamodb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Configuration
public class DynamoDbConfig {

    @Value("${dynamodb.port:8000}")
    private Integer port;

    @Value("${dynamodb.server:http://localhost}")
    private String server;

    @Value("${aws.region:us-east-1}")
    private String region;


    @Bean(name = "amazonDDBClient")
    public AmazonDynamoDB createConnection() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(generateUrl(), region))
                .build();
    }

    private String generateUrl() {
        return new StringBuilder(server)
                .append(":")
                .append(port)
                .toString();
    }

    @Bean
    public DynamoDB createDynamoDB(AmazonDynamoDB client) {
        return new DynamoDB(client);
    }

    @Bean
    public DynamoDBMapper createMapper(AmazonDynamoDB client) {
        return new DynamoDBMapper(client);
    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
