package com.bookstore.payment1.repository.model;

import com.github.f4b6a3.ulid.Ulid;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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

    private String uuid;

    @Singular
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Set<BookEntity> books;

    @Builder
    public AuthorEntity(String name, Set<BookEntity> books, String uuid) {
        this.name = name;
        this.books = books;
        this.uuid = uuid;
    }
}
