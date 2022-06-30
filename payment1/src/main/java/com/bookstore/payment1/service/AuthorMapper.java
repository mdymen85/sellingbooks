package com.bookstore.payment1.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import com.bookstore.payment1.dto.AuthorCreated;
import com.github.f4b6a3.ulid.Ulid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.domain.Book;
import com.bookstore.payment1.dto.CreateAuthor;
import com.bookstore.payment1.dto.CreateBook;

@Mapper(imports = UUID.class, componentModel = "spring")
public interface AuthorMapper {

	@Mapping(source = "name", target = "name")
	@Mapping(target = "ulid", expression = "java(uuid())")
	Author to(CreateAuthor createAuthor);
	
	@Mapping(source = "name", target = "name")
	@Mapping(source = "pages", target = "pages")
	@Mapping(target = "uuid", expression = "java(uuid())")
	@Mapping(source = "stock", target = "stock")
	Book to(CreateBook createBook);
	
	List<Book> toCreateBooks(List<CreateBook> createBooks);

//	private final Ulid id;
//	private final String name;
//	private final int pages;
//	private final Long stock;
//
//	private String name;
//	private int pages;
//	private Long stock;
//	private String uuid;
	@Mapping(target="name", source="name")
	@Mapping(target="pages", source = "pages")
	@Mapping(target="stock", source = "stock")
	@Mapping(target="uuid", expression = "java(toString(book.getUuid()))")
	CreateBook to(Book book);

	default String toString(Ulid ulid) {
		return ulid.toString();
	}

	List<CreateBook> to(List<Book> books);

	@Mapping(source = "name", target = "name")
	@Mapping(source = "ulid", target = "id")
	AuthorCreated to(Author author);

	default Ulid uuid() {
		return UlidCreator.monotincUlid();
	}
}
