package com.bookstore.payment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CreditCardCache {

	private static int number = 0; 
	
	@Autowired
	private ConsultCreditCard consultCreditCard;
	
	@Cacheable( cacheResolver = "customCacheResolver")
	public String get(int param1) {
		consultCreditCard.xxx();
		number++;
		System.out.println("entrou..." + number);
		return "A";
	}
	
}
