package com.bookstore.payment2.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

import java.math.BigInteger;

@Getter
@ToString
@DynamoDBDocument
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private Long id;
	private String name;
	private int pages;
	private Long stock;
	private String uuid;
}
