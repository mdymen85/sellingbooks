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
@Table(name = "SB_BOOKS")
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int pages;

    @Column(name = "UUID", precision = 40, scale = 0)
    private String uuid;

    @Builder
    public BookEntity(String name, int pages, Ulid uuid) {
        this.name = name;
        this.pages = pages;
        this.uuid = uuid.toString();
    }
}
