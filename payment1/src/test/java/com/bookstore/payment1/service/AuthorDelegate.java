package com.bookstore.payment1.service;

import com.bookstore.payment1.dto.AuthorCreated;
import com.bookstore.payment1.dto.CreateAuthor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@RequiredArgsConstructor
@Component
public class AuthorDelegate {

    private final CreateAuthorService createAuthorService;

    public AuthorCreated createAuthor(CreateAuthor createAuthor) {
        return createAuthorService.createAuthor(createAuthor);
    }

}

