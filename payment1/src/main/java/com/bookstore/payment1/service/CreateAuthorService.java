package com.bookstore.payment1.service;

import javax.persistence.EntityManager;

import com.bookstore.payment1.domain.Author;
import com.bookstore.payment1.repository.AuthorRepository;
import com.bookstore.payment1.repository.AuthorServiceRepository;
import org.apache.camel.ExchangePattern;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Route;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.payment1.dto.AuthorCreated;
import com.bookstore.payment1.dto.CreateAuthor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.bookstore.payment1.domain.Author;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CreateAuthorService {

	private final AuthorMapper authorMapper;
	private final AuthorServiceRepository authorServiceRepository;

	@Produce(uri = "direct:startQueuePoint")
	private ProducerTemplate template;

	public AuthorCreated createAuthor(CreateAuthor createAuthor) {
		
		var author = authorMapper.to(createAuthor);

		this.authorServiceRepository.createAuthor(author);

		//template.asyncSendBody(template.getDefaultEndpoint(), author);

		return this.authorMapper.to(author);
	}
	
}
