package com.bookstore.routebooks.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@Entity
@Table(name = "SB_BOOKS")
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int pages;

    @Column(name = "UUID", precision = 40, scale = 0)
    private BigDecimal uuid;

    @Builder
    public BookEntity(String name, int pages, BigDecimal uuid) {
        this.name = name;
        this.pages = pages;
        this.uuid = uuid;
    }
}
