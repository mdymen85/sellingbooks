package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.repository.model.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorServiceRepository {

    private final AuthorRepository authorRepository;
    private final AuthorRepositoryMapper authorRepositoryMapper;

    public void createAuthor(Author author) {
        var authorEntity = this.authorRepositoryMapper.to(author);
        this.authorRepository.save(authorEntity);
    }

}
