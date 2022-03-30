package com.bookstore.payment1.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.bookstore.payment1.model.book.Author;

public interface IAuthorRepository {

	Optional<Author> findByIdentityPersonalNumber(String identity);
	
	Optional<Author> findWithBooks(@Param("id") String id);
	
	Author save(Author author);
	
}
