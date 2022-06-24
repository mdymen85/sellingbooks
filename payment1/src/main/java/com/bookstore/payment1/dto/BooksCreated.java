package com.bookstore.payment1.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
public class BooksCreated {

    private BigInteger id;
    private String name;

    @Singular("book")
    private final List<CreateBook> books;

}
