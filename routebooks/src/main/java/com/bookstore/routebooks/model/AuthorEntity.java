package com.bookstore.routebooks.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name="SB_AUTHOR")
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "UUID", precision = 40, scale = 0)
    private BigDecimal uuid;

    @Singular
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<BookEntity> books;

    @Builder
    public AuthorEntity(String name, Set<BookEntity> books, BigDecimal uuid) {
        this.name = name;
        this.books = books;
        this.uuid = uuid;
    }
}
