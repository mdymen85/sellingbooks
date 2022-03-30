package com.bookstore.payment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultCreditCard {

	@Autowired
	private CustomCache customCache;
	
	public void xxx() {
		customCache.put(1, "A");
		customCache.put(5, "A");
		customCache.put(6, "B");
		customCache.put(10, "B");
	}
	
}
