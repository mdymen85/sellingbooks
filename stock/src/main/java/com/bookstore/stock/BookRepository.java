package com.bookstore.stock;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Optional<Book> findByBookUuid(String uuid);

}
