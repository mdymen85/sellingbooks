package com.bookstore.payment1.model.book;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Table(name = "BOOK")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="entityx", 
//discriminatorType = DiscriminatorType.INTEGER)
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
