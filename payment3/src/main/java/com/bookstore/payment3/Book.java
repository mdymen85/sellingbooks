package com.bookstore.payment3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="p3_sb_book")
@Builder
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "author_uuid", nullable = false)
    private String authorUuid;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_uuid", nullable = false)
    private String bookUuid;

    @Column(name = "stock", nullable = false)
    private Long stock;

    public Book() {

    }
}
