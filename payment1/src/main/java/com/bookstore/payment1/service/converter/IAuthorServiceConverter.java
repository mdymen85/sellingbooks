package com.bookstore.payment1.service.converter;

import com.bookstore.payment1.dto.AuthorRequest;
import com.bookstore.payment1.dto.AuthorResponse;

public interface IAuthorServiceConverter {

	AuthorResponse save(AuthorRequest authorRequest);

}
