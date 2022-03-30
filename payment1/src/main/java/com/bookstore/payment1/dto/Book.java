package com.bookstore.payment1.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Book {

	private final String name;
	private final int pages;
	
}
