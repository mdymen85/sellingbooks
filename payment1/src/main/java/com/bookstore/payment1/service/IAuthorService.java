package com.bookstore.payment1.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.repository.IAuthorRepository;
import com.bookstore.payment1.repository.impl.AuthorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public interface IAuthorService {	
	
	public Author save(Author author);	
	
	public Optional<Author> load(String id);
	
	
}
