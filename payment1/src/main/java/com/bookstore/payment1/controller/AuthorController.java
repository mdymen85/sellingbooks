package com.bookstore.payment1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.payment1.dto.AuthorRequest;
import com.bookstore.payment1.dto.AuthorResponse;
import com.bookstore.payment1.dto.BookRequest;
import com.bookstore.payment1.service.IAuthorService;
import com.bookstore.payment1.service.converter.IAuthorServiceConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {
	
	private final IAuthorServiceConverter authorServiceConverter;

	@RequestMapping(path = "/v1/author", method = RequestMethod.POST)
	public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest authorRequest) {
		var response = authorServiceConverter.save(authorRequest);
		return new ResponseEntity<AuthorResponse>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/v1/author", method = RequestMethod.PUT)
	public ResponseEntity<AuthorResponse> update(@RequestBody AuthorRequest authorRequest) {
		
		return new ResponseEntity<AuthorResponse>(new AuthorResponse(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/v1/author/{identity}", method = RequestMethod.DELETE)
	public void delete(@RequestParam Long identity) {
		
	}
	
	@RequestMapping(path = "/v1/author/{author}/book")
	public void addBook(@PathVariable("author") String authorId, @RequestBody BookRequest bookRequest) {
		
	}
	
}
