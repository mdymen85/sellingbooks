package com.bookstore.payment1.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.repository.IAuthorRepository;
import com.bookstore.payment1.service.IAuthorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

	private final IAuthorRepository authorRepository;
	
	public Author save(Author author) {
		log.info("Saveing: {}", author);
		return this.authorRepository.save(author);
	}
	
	public Optional<Author> load(String id) {
		return this.authorRepository.findWithBooks(id);
	}
	
}
