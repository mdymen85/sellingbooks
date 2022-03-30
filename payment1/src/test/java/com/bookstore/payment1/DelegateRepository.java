package com.bookstore.payment1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.model.book.Book;
import com.bookstore.payment1.repository.impl.AuthorRepository;
import com.bookstore.payment1.repository.impl.BookRepository;

import lombok.RequiredArgsConstructor;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
@RequiredArgsConstructor
public class DelegateRepository {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public Author save(Author author) {
		return this.authorRepository.save(author);
	}
	
	public Book save(Book book) {
		return this.bookRepository.save(book);
	}
	
}
