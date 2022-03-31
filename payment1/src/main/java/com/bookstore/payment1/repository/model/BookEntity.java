package com.bookstore.payment1.repository.model;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;

@ToString
@Entity
@Table(name = "SB_BOOKS")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private final String name;
    private final int pages;
    private final BigInteger uuid;

    public BookEntity() {
        this.name = null;
        this.pages = 0;
        this.uuid  = null;
    }

    @Builder
    public BookEntity(String name, int pages, BigInteger uuid) {
        this.name = name;
        this.pages = pages;
        this.uuid = uuid;
    }

}
