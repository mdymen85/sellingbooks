package com.bookstore.payment1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Optional<Author> findByIdentityIdentity(String identity);
	
	@Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.identity.identity = :identity")
	Optional<Author> findWithBooks(@Param("identity") String identity);
	
	

}
