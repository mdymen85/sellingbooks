package com.bookstore.payment1.model.book;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Singular;

@Entity
@Table(name = "BOOK")
//@DiscriminatorValue("2")
public class UpdateBook extends Book {

	@ManyToMany
	@JoinTable(
			name = "AUTHOR_BOOK",
			joinColumns = {@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id")}
			)
	@Singular(value = "author")
	private Set<Author> authors;
	
	public UpdateBook() {}
	
	@Builder
	public UpdateBook(Long id, String name, Set<Author> authors) {
		super(id, name);
		this.authors = authors;
	}
	
}
