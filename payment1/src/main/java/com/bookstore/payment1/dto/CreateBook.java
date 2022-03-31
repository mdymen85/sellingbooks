package com.bookstore.payment1.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@RequiredArgsConstructor
public class CreateBook {

	private final String name;
	private final int pages;
	
}
