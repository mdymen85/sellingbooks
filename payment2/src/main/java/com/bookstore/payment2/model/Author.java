package com.bookstore.payment2.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@DynamoDBTable(tableName="Author")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author {

	@DynamoDBHashKey
	private String uuid;

	@DynamoDBRangeKey
	private String name;

	private List<Book> books;

}
