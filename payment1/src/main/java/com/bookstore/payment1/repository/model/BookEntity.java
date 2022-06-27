package com.bookstore.payment1.repository.model;

import com.github.f4b6a3.ulid.Ulid;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@ToString
@Entity
@Table(name = "sb_books")
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int pages;
    private Long stock;

    @Column(name = "UUID")
    private String uuid;

    @Builder
    public BookEntity(String name, int pages, Ulid uuid, Long stock) {
        this.name = name;
        this.pages = pages;
        this.uuid = uuid.toString();
        this.stock = stock;
    }
}
