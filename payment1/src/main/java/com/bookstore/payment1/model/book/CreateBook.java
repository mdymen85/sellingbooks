package com.bookstore.payment1.model.book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "BOOK")
//@DiscriminatorValue("1")
public class CreateBook extends Book {

	@ManyToMany(mappedBy="books")
	@Singular(value = "author")
	private Set<Author> authors;

	
	public CreateBook() {}
	
	@Builder
	public CreateBook(Long id, String name, Set<Author> authors) {
		super(id, name);	
		this.authors = authors;
	} 
	
}
