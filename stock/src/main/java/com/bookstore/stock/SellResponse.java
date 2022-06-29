package com.bookstore.stock;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SellResponse {

    private String bookId;
    private int quantity;
    private Long stock;
    private Instant bought;

}
