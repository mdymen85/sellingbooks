package com.bookstore.payment1.service;

import com.github.f4b6a3.ulid.Ulid;

import java.math.BigInteger;
import java.util.UUID;

public class CreateIds {

	public static Ulid createId() {
		return com.github.f4b6a3.ulid.UlidCreator.getMonotonicUlid();
	}
	
}
