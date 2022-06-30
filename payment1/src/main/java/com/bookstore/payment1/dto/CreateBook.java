package com.bookstore.payment1.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBook {

	private String name;
	private int pages;
	private Long stock;
	private String uuid;
	
}
