package com.sellingbooks.buy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuyApplicationTests {

	@Autowired
	private UlidCreator ulidCreator;

	@Test
	void contextLoads() {

		long x = 2191064382L;

		var ulid = ulidCreator.monotincUlid();
		var ulid2 = ulidCreator.monotincUlid();

		System.out.println(ulid);
		System.out.println(ulid2);
	}

}
