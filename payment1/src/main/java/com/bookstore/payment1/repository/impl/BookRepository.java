package com.bookstore.payment1.repository.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.Book;
import com.bookstore.payment1.model.book.CreateBook;
import com.bookstore.payment1.repository.IBookRepository;

@Repository
public interface BookRepository extends IBookRepository, CrudRepository<Book, Long> {

}
