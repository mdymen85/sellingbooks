package com.bookstore.payment1.repository.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@Entity
@Table(name = "sb_outbox")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutboxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @Column(name = "object_json")
    private String objectJson;

}
