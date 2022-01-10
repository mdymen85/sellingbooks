package com.bookstore.payment1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.payment1.DelegateRepository;
import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.model.book.Book;
import com.bookstore.payment1.model.book.Identity;
import com.bookstore.payment1.repository.AuthorRepository;

@SpringBootTest
public class AuthorServiceTest {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private DelegateRepository txDelegate;
	
	@Test
	void createAuthorWithBook() {
		var author = Author.builder()
				.name("Bini Stein")
				.identity(new Identity("ID1234"))
				.book(Book.builder()
						.name("Truth")
						.build())
				.book(Book.builder()
						.name("Lies")
						.build())				
				.build();
		
		
		var authorSaved = this.txDelegate.save(author);
		
		System.out.println(authorSaved);
				
		
	}
	
	@Test
	void saveBookAfterCreateAuthor() {
		var author = Author.builder()
				.name("Bini Stein")
				.identity(new Identity("ID1234"))
				.book(Book.builder()
						.name("Truth")
						.build())				
				.build();		
		
		var authorSaved = this.txDelegate.save(author);
		
		var authorLoaded = authorService.loadReference(null);
						
		authorLoaded
			.add(Book.builder()
					.name("Lies")
					.build());
		
		var newSaved = this.txDelegate.save(authorLoaded);
		
		System.out.println(newSaved);
	}
	
}
