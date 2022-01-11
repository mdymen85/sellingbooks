package com.bookstore.payment1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.Book;
import com.bookstore.payment1.model.book.CreateBook;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
