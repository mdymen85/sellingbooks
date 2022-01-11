package com.bookstore.payment1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.model.book.Author;
import com.bookstore.payment1.model.book.CreateBook;
import com.bookstore.payment1.model.book.UpdateBook;
import com.bookstore.payment1.repository.AuthorRepository;
import com.bookstore.payment1.repository.BookRepository;
import com.bookstore.payment1.repository.UpdateBookRepository;

import lombok.RequiredArgsConstructor;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
@RequiredArgsConstructor
public class DelegateRepository {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final UpdateBookRepository updateRepository;
	
	public Author save(Author author) {
		return this.authorRepository.save(author);
	}
	
	public CreateBook save(CreateBook book) {
		return this.bookRepository.save(book);
	}
	
	public UpdateBook save(UpdateBook book) {
		return this.updateRepository.save(book);
	}
	
}
