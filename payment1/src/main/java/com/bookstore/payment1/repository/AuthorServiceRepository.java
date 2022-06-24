package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.repository.model.AuthorEntity;
import com.bookstore.payment1.repository.model.OutboxEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.camel.util.json.Jsoner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorServiceRepository {

    private final AuthorRepository authorRepository;
    private final AuthorRepositoryMapper authorRepositoryMapper;
    private final OutboxRepository outboxRepository;
    private final ObjectMapper objectMapper;

    public void createAuthor(Author author) {
        try {

            var authorEntity = this.authorRepositoryMapper.to(author);

            var outboxEntity = OutboxEntity
                    .builder()
                    .uuid(authorEntity.getUuid())
                    .objectJson(objectMapper.writeValueAsString(authorEntity))
                    .build();

            this.outboxRepository.save(outboxEntity);
            this.authorRepository.save(authorEntity);
        }
        catch (JsonProcessingException e) {
            throw new IllegalStateException();
        }
    }

    public Author findAuthor(String id) {
        Optional<AuthorEntity> optAuthorEntity = this.authorRepository.findByUuid(id);
        if (!optAuthorEntity.isPresent()) {
            throw new IllegalStateException();
        }

        var authorEntity = optAuthorEntity.get();

        return authorRepositoryMapper.to(authorEntity);
    }

}
