package com.fastcode.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.fastcode.inf.ICacheService;

@Service("cacheService")
public class CacheServiceImpl implements ICacheService {
	private final AtomicInteger i = new AtomicInteger();

	@Override
	public String findCache(String id) {
		System.out.println("=====findCache:====" + id);
	         return "request: " + id + ", response: " + i.getAndIncrement();  
	}

}
