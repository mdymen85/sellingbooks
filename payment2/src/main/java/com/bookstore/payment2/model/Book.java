package com.bookstore.payment2.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

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
