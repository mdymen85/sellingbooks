package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.domain.Book;
import com.bookstore.payment1.repository.model.AuthorEntity;
import com.bookstore.payment1.repository.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AuthorRepositoryMapper {

    @Mapping(target = "name", source = "author.name")
    @Mapping(target = "uuid", source = "author.id")
    AuthorEntity to(Author author);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "pages", source = "pages")
    @Mapping(target = "uuid", source = "id")
    BookEntity to(Book book);

    List<BookEntity> to(List<Book> books);

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "name", source = "name")
    Author to(AuthorEntity authorEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "pages", target = "pages")
    @Mapping(source = "uuid", target = "id")
    Book to(BookEntity bookEntity);

    Set<Book> to(Set<BookEntity> books);
}
