package com.bookstore.payment1.repository.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.repository.IAuthorRepository;

@Repository
public interface AuthorRepository extends IAuthorRepository, CrudRepository<Author, Long> {
	
	@Override
	@Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.identity.personalNumber = :personalNumber")
	Optional<Author> findWithBooks(@Param("personalNumber") String personalNumber);

}
