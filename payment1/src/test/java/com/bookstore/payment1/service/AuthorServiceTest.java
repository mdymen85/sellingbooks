package com.bookstore.payment1.service;

import com.bookstore.payment1.dto.CreateAuthor;
import com.bookstore.payment1.dto.CreateBook;
import com.bookstore.payment1.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .name("Author1")
                .build();

        var authorCreated = this.authorDelegate.createAuthor(createAuthor);

        assertEquals(authorCreated.getBooks().size(), 0);
        assertEquals(authorCreated.getName(), createAuthor.getName());
        assertNotNull(authorCreated.getId());

        var authorEntity = this.authorRepository.findByUuid(authorCreated.getId()).get();

        assertEquals(authorCreated.getBooks().size(), 0);
        assertEquals(authorCreated.getName(), authorEntity.getName());
        assertEquals(authorCreated.getId(), authorEntity.getUuid());

    }

    @Test
    public void createAuthorWithBooksTest() {

        var book1 = CreateBook.builder()
                .name("Book1")
                .pages(200)
                .build();

        var book2 = CreateBook.builder()
                .name("book2")
                .pages(300)
                .build();

        var author = CreateAuthor.builder()
                .name("author")
                .book(book1)
                .book(book2)
                .build();

        var authorCreated = this.authorDelegate.createAuthor(author);

        var authorEntity = this.authorRepository.findByUuid(authorCreated.getId()).get();

        var bookEntity1 = authorEntity
                .getBooks()
                .stream()
                .filter(b -> b.getName().equals(book1.getName()))
                .findAny()
                .get();

        assertEquals(bookEntity1.getPages(), book1.getPages());
        assertEquals(bookEntity1.getName(), book1.getName());

        var bookEntity2 = authorEntity
                .getBooks()
                .stream()
                .filter(b -> b.getName().equals(book2.getName()))
                .findAny()
                .get();

        assertEquals(bookEntity2.getPages(), book2.getPages());
        assertEquals(bookEntity2.getName(), book2.getName());
    }
	
}
