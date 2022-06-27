package com.sellingbooks.buy;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorResponse {

    private String uuid;
    private String name;
    private List<BookResponse> books;

}
