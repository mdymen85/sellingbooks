package com.bookstore.payment2.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomCacheResolver implements CacheResolver {

	@Autowired
	private CustomCache customCache;
	
	@Override
	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		// TODO Auto-generated method stub
		return List.of(customCache);
	}

}
