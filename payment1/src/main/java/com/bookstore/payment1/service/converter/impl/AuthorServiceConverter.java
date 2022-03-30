package com.bookstore.payment1.service.converter.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookstore.payment1.dto.AuthorBookRequest;
import com.bookstore.payment1.dto.AuthorRequest;
import com.bookstore.payment1.dto.AuthorResponse;
import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.model.book.CreateBook;
import com.bookstore.payment1.model.book.Identity;
import com.bookstore.payment1.service.IAuthorService;
import com.bookstore.payment1.service.converter.IAuthorServiceConverter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceConverter implements IAuthorServiceConverter {

	private IAuthorService authorService;
	
	@Override
	public AuthorResponse save(AuthorRequest authorRequest) {		
		var author = this.toAuthor(authorRequest);
		var authorSaved = this.authorService.save(author);
		
		return null;
	}

	private Author toAuthor(AuthorRequest authorRequest) {
		var booksRequest = authorRequest.getBooks();
		
		var author = Author.builder()
				.identity(new Identity(authorRequest.getPersonalNumber()))
				.name(authorRequest.getName())
				.build();
		
		var books = booksRequest.stream()
				.map(b -> this.toCreateBook(b, author))
				.collect(Collectors.toList());
				
		books.stream()
			.forEach(book -> {
				author.addBook(book);
			});
		
		
		return author;

	}
	
	private CreateBook toCreateBook(AuthorBookRequest authorBookRequest, Author author) {
		return CreateBook.builder()
				.authors(Set.of(author))
				.name(authorBookRequest.getName())
				.build();
				
	}
	
//	private AuthorResponse toAuthorResponse(Author author) {
//		
//	}
	
}
