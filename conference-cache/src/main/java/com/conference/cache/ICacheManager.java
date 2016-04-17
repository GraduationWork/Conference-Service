package com.conference.cache;

public interface ICacheManager {
	public Object get(String key);
	public void put(String key, Object entity);
	public void put(String key, Object entity, int expiry);
	public void flush(String key);
}
