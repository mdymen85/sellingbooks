package com.bookstore.payment1.domain;

import java.math.BigInteger;

import com.github.f4b6a3.ulid.Ulid;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Book {

	private final Ulid id;
	private final String name;
	private final int pages;
	private final Long stock;
	
	public Book(Ulid id, String name, int pages, Long stock) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.stock = stock;
	}
	
}
