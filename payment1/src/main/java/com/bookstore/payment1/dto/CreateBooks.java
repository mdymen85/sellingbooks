package com.bookstore.payment1.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Data
@Builder
public class CreateBooks {

    @Singular("book")
    private List<CreateBook> books;

}
