package com.bookstore.payment1.model.book;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Embeddable
@Getter
@ToString
public class Identity {

	private String identity;
	
	public Identity() {}
	
	@Builder
	public Identity(String identity) {
		this.identity = identity;
	}
	
	
	
}
