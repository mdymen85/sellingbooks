package com.bookstore.payment1.service;

import java.math.BigInteger;
import java.util.UUID;

public class CreateIds {

	public static BigInteger createId() {
		return new BigInteger(UUID.randomUUID().toString().replace("-", ""));
	}
	
}
