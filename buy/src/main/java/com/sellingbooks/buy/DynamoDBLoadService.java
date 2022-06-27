package com.sellingbooks.buy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DynamoDBLoadService {

    private static final String TABLE_NAME = "Author";

    private final DynamoDBMapper mapper;
    private final DynamoDB dynamoDb;
    private final ObjectMapper objectMapper;
    
    public AuthorResponse createDynamoDBTables(String id, String name) throws JsonProcessingException {

        var author = mapper.load(Author.class, id, name);
        log.info("Author {}", author);

        var books = objectMapper.readValue(author.getBooks(), new TypeReference<List<BookResponse>>(){});

        return AuthorResponse.builder()
                .books(books)
                .uuid(author.getUuid())
                .name(author.getName())
                .build();
    }

}
