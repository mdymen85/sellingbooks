package com.bookstore.payment1.model.book;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Book() {}
	
	public Book(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
