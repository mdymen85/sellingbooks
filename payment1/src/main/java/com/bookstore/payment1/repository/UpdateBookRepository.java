package com.bookstore.payment1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.payment1.model.book.UpdateBook;

@Repository
public interface UpdateBookRepository extends CrudRepository<UpdateBook, Long> {

}
