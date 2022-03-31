package com.bookstore.payment1.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

@Data
@ToString
public class AuthorCreated {

	private final String name;

	private final BigInteger id;

	@Singular("book")
	private final List<CreateBook> books;

	@Builder
	public AuthorCreated(String name, List<CreateBook> books, BigInteger id) {
		this.name = name;
		this.books = books;
		this.id = id;
	}
	
}
