package com.bookstore.payment1.model.book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="BOOK")
@Getter
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	public Book() {}
	
	@Builder
	public Book(Long id, String name) {
		this.id = id;
		this.name = name;		
	}
	
}
