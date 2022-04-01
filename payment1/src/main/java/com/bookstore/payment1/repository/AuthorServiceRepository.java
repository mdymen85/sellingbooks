package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.repository.model.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorServiceRepository {

    private final AuthorRepository authorRepository;
    private final AuthorRepositoryMapper authorRepositoryMapper;

    public void createAuthor(Author author) {
        var authorEntity = this.authorRepositoryMapper.to(author);
        this.authorRepository.save(authorEntity);
    }

    public Author findAuthor(BigDecimal id) {
        Optional<AuthorEntity> optAuthorEntity = this.authorRepository.findByUuid(id);
        if (!optAuthorEntity.isPresent()) {
            throw new IllegalStateException();
        }

        var authorEntity = optAuthorEntity.get();

        return authorRepositoryMapper.to(authorEntity);
    }

}
