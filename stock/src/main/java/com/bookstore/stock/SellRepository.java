package com.bookstore.stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends CrudRepository<Sell, Long> {
}
