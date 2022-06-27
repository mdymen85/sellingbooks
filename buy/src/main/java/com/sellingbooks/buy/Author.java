package com.sellingbooks.buy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@DynamoDBTable(tableName="Author")
@Data
@ToString
public class Author {

    @DynamoDBHashKey
    private String uuid;

    @DynamoDBRangeKey
    private String name;

    private String books;
}
