package com.bookstore.payment1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.payment1.dto.AuthorCreated;
import com.bookstore.payment1.dto.CreateAuthor;
import com.bookstore.payment1.service.CreateAuthorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {

	private final CreateAuthorService createAuthorService;
	
	@RequestMapping(path = "/v1/author", method = RequestMethod.POST)
	public ResponseEntity<AuthorCreated> create(@RequestBody CreateAuthor createAuthor) {
		
		var authorCreated = this.createAuthorService.createAuthor(createAuthor);
		return new ResponseEntity<AuthorCreated>(authorCreated, HttpStatus.CREATED);
		
	}
	
}
