package com.bookstore.payment1.dto;

import java.util.List;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthor {
	
	private String name;

	@Singular("book")
	private List<CreateBook> books;
	
}
