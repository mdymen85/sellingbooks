package com.bookstore.payment1.repository;

import com.bookstore.payment1.repository.model.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findByUuid(String uuid);

}
