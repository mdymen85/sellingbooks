package com.bookstore.payment1.repository;

import com.bookstore.payment1.repository.model.OutboxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxRepository extends CrudRepository<OutboxEntity, Long> {
}
