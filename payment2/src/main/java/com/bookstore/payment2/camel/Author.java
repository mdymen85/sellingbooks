package com.bookstore.payment2.camel;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Set;

@Getter
@ToString
public class Author {

	private final String name;
	private final BigInteger id;
	
	@Singular("book")
	private final Set<Book> books;

	public Author() {
		this.id = null;
		this.name = null;
		this.books = null;
	}

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
