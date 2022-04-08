package com.bookstore.routebooks.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@Entity
@Table(name = "SB_OUTBOX")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutboxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 40, scale = 0)
    private BigDecimal uuid;
    private String objectJson;

}
