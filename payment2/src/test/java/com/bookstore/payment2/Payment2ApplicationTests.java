package com.bookstore.payment2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.payment2.service.CreditCardCache;

@SpringBootTest
class Payment2ApplicationTests {

	@Autowired
	private CreditCardCache creditCardCache;
	
	@Test
	void contextLoads() {
		
		System.out.println(this.creditCardCache.get(1));
		System.out.println(this.creditCardCache.get(3));
		System.out.println(this.creditCardCache.get(5));
		System.out.println(this.creditCardCache.get(6));
		
	}

}
