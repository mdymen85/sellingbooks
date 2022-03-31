package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.domain.Book;
import com.bookstore.payment1.repository.model.AuthorEntity;
import com.bookstore.payment1.repository.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AuthorRepositoryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "uuid", target = "uuid")
    AuthorEntity to(Author author);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "pages", target = "pages")
    @Mapping(source = "uuid", target = "uuid")
    BookEntity to(Book book);

    List<BookEntity> to(List<Book> book);

}
