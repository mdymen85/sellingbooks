package com.sellingbooks.buy;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Value("${dynamodb.port:8000}")
    private Integer port;

    @Value("${dynamodb.server:http://localhost}")
    private String server;

    @Value("${aws.region:us-east-1}")
    private String region;


    @Bean(name = "amazonDynamoDB")
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

}
