package com.bookstore.payment1.controller;

import com.bookstore.payment1.dto.CreateBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//	@RequestMapping(path = "/v1/author/{id}/book", method = RequestMethod.POST)
//	public ResponseEntity<AuthorCreated> addBook(@PathVariable("id") String id, @RequestBody CreateBook createBook) {
//
//		var authorCreated = this.createAuthorService.addBook(createBook);
//		return new ResponseEntity<AuthorCreated>(authorCreated, HttpStatus.CREATED);
//
//	}
	
}
