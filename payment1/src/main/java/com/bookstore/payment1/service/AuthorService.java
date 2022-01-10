package com.bookstore.payment1.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final EntityManager entityManager;
	
	public Author save(Author author) {
		log.info("Saveing: {}", author);
		return this.authorRepository.save(author);
	}
	
	public Author loadReference(String identification) {
		return entityManager.getReference(Author.class, 1L);
	}
	
}
