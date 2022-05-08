package com.sellingbooks.buy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class DynamoDBLoad {

    private static final String TABLE_NAME = "Author";

    private final DynamoDBMapper mapper;
    private final DynamoDB dynamoDb;

    @EventListener(ApplicationReadyEvent.class)
    public void createDynamoDBTables() {

        var author = mapper.load(Author.class, "233213366013667932334575724438134257805", "Bini");
        log.info("Author {}", author);
    }

}
