package com.bookstore.payment1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
@RequiredArgsConstructor
public class DelegateRepository {

	private final AuthorRepository authorRepository;
	
	public Author save(Author author) {
		return this.authorRepository.save(author);
	}
	
}
