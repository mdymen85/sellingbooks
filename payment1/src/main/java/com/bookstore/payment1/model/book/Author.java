package com.bookstore.payment1.model.book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * Author is the aggregate root of the Domain.
 * 
 * @author mdymen85
 *
 */
@Entity
@Table(name = "AUTHOR")
@Getter
@Builder
@ToString
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Embedded
	private Identity identity;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(
			name = "AUTHOR_BOOK",
			joinColumns = {@JoinColumn(name = "author_id")},
			inverseJoinColumns = {@JoinColumn(name = "book_id")}
			)
	@Singular("book")
	private Set<Book> books;
	
	public Author() {
		
	}
	
	public Author(Long id, String name, Identity identity, Set<Book> books) {
		this.id = id;
		this.name = name;
		this.identity = identity;
		this.books = books;				
		
	}

	public void add(Book book) {
		this.books.add(book);
		
	}

}
