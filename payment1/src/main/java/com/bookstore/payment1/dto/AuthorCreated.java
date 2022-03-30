package com.bookstore.payment1.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthorCreated extends CreateAuthor {

	private final BigInteger id;
	
	@Builder
	public AuthorCreated(String name, List<Book> books, BigInteger id) {
		super(name, books);
		this.id = id;
	}
	
}
