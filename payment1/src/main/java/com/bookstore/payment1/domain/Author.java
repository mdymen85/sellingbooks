package com.bookstore.payment1.domain;

import java.math.BigInteger;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString
public class Author {

	private final String name;
	private final BigInteger id;
	
	@Singular("book")
	private final Set<Book> books;
	
	@Builder
	public Author(BigInteger id, String name, Set<Book> books) {
		this.name = name;
		this.books = books;
		this.id = id;
	}
	
	public void addBook(Book book) {
		if (!this.books.add(book)) {
			throw new IllegalStateException();
		}		
	}
	
	
	
}
