package com.bookstore.payment1.repository.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@ToString
@Entity
@Table(name="SB_AUTHOR")
public class AuthorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private final String name;

    private final BigInteger uuid;

    @Singular
    @OneToMany
    private final Set<BookEntity> books;

    public AuthorEntity(){
        this.name = null;
        this.books = null;
        this.uuid = null;
    }

    @Builder
    public AuthorEntity(String name, Set<BookEntity> books, BigInteger uuid) {
        this.name = name;
        this.books = books;
        this.uuid = uuid;
    }

}
