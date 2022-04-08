package com.bookstore.payment2;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DynamoDBTables {

    private static final String TABLE_NAME = "Author";

    private final DynamoDBMapper mapper;
    private final DynamoDB dynamoDb;

    @EventListener(ApplicationReadyEvent.class)
    public void createDynamoDBTables() {
        try {
            System.out.println("Attempting to create table; please wait...");
            Table table = dynamoDb.createTable(TABLE_NAME,
                    Arrays.asList(new KeySchemaElement("uuid", KeyType.HASH), // Partition
                            // key
                            new KeySchemaElement("id", KeyType.RANGE)), // Sort key
                    Arrays.asList(new AttributeDefinition("uuid", ScalarAttributeType.N),
                            new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(10L, 10L));
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
        }
        catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }

}
