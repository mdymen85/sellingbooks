package com.bookstore.payment1;

import com.bookstore.payment1.domain.Book;
import com.bookstore.payment1.dto.CreateAuthor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.payment1.dto.CreateBook;
import com.bookstore.payment1.service.AuthorMapper;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthorMapperTest {

	@Autowired
	private AuthorMapper authorMapper;
	
	@Test
	public void createBookToBook() {
		
		var createBook = CreateBook
					.builder()
					.name("book-test1")
					.pages(10)
					.build();
		
		var book = authorMapper.to(createBook);
		
		assertEquals(createBook.getName(), book.getName());
		assertEquals(createBook.getPages(), book.getPages());
		assertNotNull(book.getUuid());

	}

	@Test
	public void createAuthorToAuthorWithoutBooks() {

		var createAuthor = CreateAuthor
				.builder()
				.name("Peter")
				.build();

		var author = authorMapper.to(createAuthor);

		assertTrue(author.getBooks().size() == 0);
		assertEquals(author.getName(), createAuthor.getName());

	}

	@Test
	public void createAuthorToAuthorWithBooks() {

		var book1 = CreateBook.builder().name("book1").pages(350).build();
		var book2 = CreateBook.builder().name("book2").pages(450).build();

		var createAuthor = CreateAuthor
				.builder()
				.book(book1)
				.book(book2)
				.name("Gartner")
				.build();

		var author = authorMapper.to(createAuthor);

		assertTrue(author.getBooks().size() == 2);
		assertEquals(createAuthor.getName(), author.getName());

		var bookCreated1 = author.getBooks().stream()
				.filter(b -> b.getName().equals(book1.getName()))
				.findAny()
				.get();


		assertEquals(bookCreated1.getPages(), book1.getPages());
		assertEquals(bookCreated1.getName(), book1.getName());
		assertNotNull(bookCreated1.getUuid());

		var bookCreated2 = author.getBooks().stream()
				.filter(b -> b.getName().equals(book2.getName()))
				.findAny()
				.get();

		assertEquals(bookCreated2.getPages(), book2.getPages());
		assertEquals(bookCreated2.getName(), book2.getName());
		assertNotNull(bookCreated2.getUuid());

	}
}