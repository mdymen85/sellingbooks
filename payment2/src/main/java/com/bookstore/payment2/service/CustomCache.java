package com.bookstore.payment2.service;

import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

@Component
public class CustomCache implements Cache {

	private NavigableMap<Object, Object> creditCardMap = new TreeMap<Object, Object>();
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "creditCard";
	}

	@Override
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueWrapper get(Object key) {
		var result = creditCardMap.floorEntry(key);
		if (result != null) {
			return new ObjectWrapper(result.getValue());
		}
		return null;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		creditCardMap.put(key, value);		
	}

	@Override
	public void evict(Object key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
