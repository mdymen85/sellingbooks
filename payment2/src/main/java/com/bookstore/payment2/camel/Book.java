package com.bookstore.payment1.domain;

import java.math.BigInteger;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Book {

	private final BigInteger id;
	private final String name;
	private final int pages;
	
	public Book(BigInteger id, String name, int pages) {
		this.id = id;
		this.name = name;
		this.pages = pages;
	}
	
}
