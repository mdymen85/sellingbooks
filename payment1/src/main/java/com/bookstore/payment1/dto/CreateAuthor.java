package com.bookstore.payment1.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class CreateAuthor {
	
	private final String name;
	
	@Singular("book")
	private final List<Book> books;
	
	
	
}
