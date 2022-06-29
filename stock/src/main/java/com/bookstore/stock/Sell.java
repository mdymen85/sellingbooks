package com.bookstore.stock;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "st_sell")
@Data
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @CreationTimestamp
    private Instant bought;

    @Builder
    public Sell(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

}
