package com.bookstore.payment1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
