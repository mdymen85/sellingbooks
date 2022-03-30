package com.bookstore.payment1.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorRequest {

	private String personalNumber;
	private String name;
	private List<AuthorBookRequest> books;
}
