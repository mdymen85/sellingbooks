package com.sellingbooks.buy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ReleaseDateConverter implements DynamoDBTypeConverter<String, String>{

	@Override
	public String convert(String releaseDate) {
		return releaseDate.toString();
	}

	@Override
	public String unconvert(String releaseDate) {
		return releaseDate;
	}

}
