package com.bookstore.payment1.service;

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
	@Mapping(target = "id", expression = "java(uuid())")
	Author to(CreateAuthor createAuthor);
	
	@Mapping(source = "name", target = "name")
	@Mapping(source = "pages", target = "pages")
	@Mapping(target = "id", expression = "java(uuid())")
	Book to(CreateBook createBook);
	
	List<Book> to(List<CreateBook> createBooks);


	AuthorCreated to(Author author);


	default Ulid uuid() {
		return UlidCreator.monotincUlid();
	}
}
