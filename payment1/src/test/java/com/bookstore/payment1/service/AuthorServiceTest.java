package com.bookstore.payment1.service;

import java.util.Set;

import com.bookstore.payment1.dto.CreateAuthor;
import com.bookstore.payment1.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.bookstore.payment1.DelegateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorDelegate authorDelegate;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void createAuthorTest() {
        var createAuthor = CreateAuthor
                .builder()
                .name("Autho1")
                .build();

        var authorCreated = this.authorDelegate.createAuthor(createAuthor);

        assertEquals(authorCreated.getBooks(), 0);
        assertEquals(authorCreated.getName(), createAuthor.getName());
        assertNotNull(authorCreated.getId());

        var authorEntity = (AuthorTest) this.authorRepository.findByUuid(authorCreated.getId()).get();
//        assertEquals(createAuthor.getName(), authorEntity.);

        System.out.println(3);

    }
	
}
