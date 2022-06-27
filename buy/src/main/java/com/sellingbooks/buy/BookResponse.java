package com.sellingbooks.buy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.github.f4b6a3.ulid.Ulid;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String uuid;
    private String name;
    private int pages;
    private Long stock;

}
