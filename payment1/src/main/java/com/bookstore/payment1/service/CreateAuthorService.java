package com.bookstore.payment1.service;

import javax.persistence.EntityManager;

import com.bookstore.payment1.repository.AuthorRepository;
import com.bookstore.payment1.repository.AuthorServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.dto.AuthorCreated;
import com.bookstore.payment1.dto.CreateAuthor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CreateAuthorService {

	private final AuthorMapper authorMapper;
	private final AuthorServiceRepository authorServiceRepository;

	public AuthorCreated createAuthor(CreateAuthor createAuthor) {
		
		var author = authorMapper.to(createAuthor);

		this.authorServiceRepository.createAuthor(author);

		//authorMapper.to
		
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Author save(Author author) {
//		log.info("Saveing: {}", author);
//		return this.authorRepository.save(author);
//	}
//	
//	public Author loadReference(String identification) {
//		return entityManager.getReference(Author.class, 1L);
//	}
//	
//	public Optional<Author> loadWithBooks(String identity) {
//		return this.authorRepository.findWithBooks(identity);
//	}
	
}
