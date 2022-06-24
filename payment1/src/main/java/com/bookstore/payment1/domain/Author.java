package com.bookstore.payment1.domain;

import java.math.BigInteger;
import java.util.Set;

import com.github.f4b6a3.ulid.Ulid;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString
public class Author {

	private final String name;
	private final Ulid ulid;
	
	@Singular("book")
	private final Set<Book> books;
	
	@Builder
	public Author(Ulid ulid, String name, Set<Book> books) {
		this.name = name;
		this.books = books;
		this.ulid = ulid;
	}
	
	public void addBook(Book book) {
		if (!this.books.add(book)) {
			throw new IllegalStateException();
		}		
	}
	
	
	
}
