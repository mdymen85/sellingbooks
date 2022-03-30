package com.bookstore.payment1.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.dto.CreateAuthor;

@Mapper
public abstract class AuthorMapper {

	@Mapping(source = "name", target = "name")
	@Mapping(source = "id", target = "java(UUID.randomUUID().toString().replace('-",'\'\)")
	public abstract Author to(CreateAuthor createAuthor);
	
	public abstract Book to(Book)
	
}
