package com.bookstore.payment1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Optional<Author> findByIdentityIdentity(String identity);

}
