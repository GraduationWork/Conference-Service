package com.conference.cache;

import net.spy.memcached.MemcachedClient;

import org.apache.commons.lang3.Validate;

public class MemcacheManager implements ICacheManager{

	private MemcachedClient client;
	private int defaultExpiry = 60 * 60;
	
	
	public MemcacheManager(MemcachedClient client) {
		Validate.notNull(client);
		this.client = client;
	}
	public MemcacheManager(MemcachedClient client, int defaultExpiry) {
		Validate.notNull(client);
		this.client = client;
		this.defaultExpiry = defaultExpiry;
	}
	
	@Override
	public Object get(String key) {
		return client.get(key);
	}

	@Override
	public void put(String key, Object entity) {
		put(key, entity, defaultExpiry);
	}

	@Override
	public void flush(String key) {
		client.delete(key);
	}

	@Override
	public void put(String key, Object entity, int expiry) {
		client.set(key, expiry, entity);
	}

	
//	try {
//	MemcachedClient c=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
	
}
