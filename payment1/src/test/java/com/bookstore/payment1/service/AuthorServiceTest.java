package com.bookstore.payment1.service;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.bookstore.payment1.DelegateRepository;
import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.model.book.CreateBook;
import com.bookstore.payment1.model.book.Identity;
import com.bookstore.payment1.model.book.UpdateBook;
import com.bookstore.payment1.repository.AuthorRepository;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorServiceTest {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private DelegateRepository txDelegate;
	
	@Test
	void createAuthorWithBook() {
//		var author = Author.builder()
//				.name("Bini Stein")
//				.identity(new Identity("ID1234"))
//				.book(Book.builder()
//						.name("Truth")
//						.build())
//				.book(Book.builder()
//						.name("Lies")
//						.build())				
//				.build();
//		
//		
//		var authorSaved = this.txDelegate.save(author);
//		
//		System.out.println(authorSaved);
				
		
	}
	
	@Test
	void saveBookAfterCreateAuthor() {
		
		var author = Author.builder()
				.identity(new Identity("D123"))
				.name("Bini")
				.build();
		
		var book = CreateBook.builder()
				.authors(Set.of(author))
				.name("Lie")
				.build();
		
		var book2 = CreateBook.builder()
				.authors(Set.of(author))
				.name("Treta")
				.build();
		
		author.addBook(book);
		author.addBook(book2);
		
		var authorSaved = this.txDelegate.save(author);

		author = Author.builder()
				.identity(new Identity("D1234"))
				.name("Stefan")
				.build();
		
		var authorSaved2 = this.txDelegate.save(author);
		
//		author.addBook(Book.builder()
//				.authors(Set.of(Author)));
				
		
		
//		var author = Author.builder()
//				.books(AuthorBook.builder()
//						.author(author))
		
		
//		var author = Author.builder()
//				.name("Bini Stein")
//				.identity(new Identity("ID1234"))
//				.book(Book.builder()
//						.name("Truth")
//						.build())				
//				.build();		
//		
//		var authorSaved = this.txDelegate.save(author);
//			
		var authorLoaded = authorRepository.findByIdentityIdentity(authorSaved.getIdentity().getIdentity()).get();			
		
		var updatebook = UpdateBook.builder()
				.authors(Set.of(authorLoaded, authorSaved2))
				.name("Thruth")
				.build();
		
		this.txDelegate.save(updatebook);
				
				
//		book = Book.builder()
//			.name("Lies")
//			.authors(Set.of(authorLoaded))
//			.build();
		
		authorLoaded.addBook(book);
		
		authorSaved = this.txDelegate.save(authorLoaded);
		
//		authorLoaded.add(book);
//		
//		var newSaved = this.txDelegate.save(authorLoaded);
//		
//		var authorx = authorService.loadWithBooks(authorSaved.getIdentity().getIdentity()).get();
//		
		System.out.println(authorSaved);

	}
	
}
