package com.bookstore.stock;

import lombok.Data;

@Data
public class SellRequest {

    private int quantity;
    private String bookId;

}
