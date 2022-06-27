package com.bookstore.payment1.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.github.f4b6a3.ulid.Ulid;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

@Data
@ToString
public class AuthorCreated {

	private final String name;

	private final String id;

	@Singular("book")
	private final List<CreateBook> books;

	@Builder
	public AuthorCreated(String name, List<CreateBook> books, Ulid id) {
		this.name = name;
		this.books = books;
		this.id = id.toString();
	}
	
}
