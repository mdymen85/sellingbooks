package com.bookstore.payment1.repository;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.domain.Book;
import com.bookstore.payment1.repository.model.AuthorEntity;
import com.bookstore.payment1.repository.model.BookEntity;
import com.github.f4b6a3.ulid.Ulid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AuthorRepositoryMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "uuid", expression = "java(convert(author.getUlid()))")
    AuthorEntity to(Author author);

    default String convert(Ulid id) {
        return id.toString();
    }

    @Mapping(target = "name", source = "name")
    @Mapping(target = "pages", source = "pages")
    @Mapping(target = "uuid", source = "id")
    BookEntity to(Book book);

    List<BookEntity> to(List<Book> books);

    @Mapping(target = "ulid", source = "uuid")
    @Mapping(target = "name", source = "name")
    Author to(AuthorEntity authorEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "pages", target = "pages")
    @Mapping(expression = "java(convertToUlid(bookEntity.getUuid()))", target = "id")
    Book to(BookEntity bookEntity);

    default Ulid convertToUlid(String uuid) {
        return Ulid.from(uuid);
    }

    Set<Book> to(Set<BookEntity> books);
}
