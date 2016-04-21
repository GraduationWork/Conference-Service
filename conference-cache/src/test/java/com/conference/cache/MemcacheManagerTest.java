package com.conference.cache;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conference.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:cache-context.xml" })
public class MemcacheManagerTest {

	@Autowired private ICacheManager cacheManager;
	
	@Test
	public void cacheTest() {
		User user = new User();
		user.setUsername("aliaksandr_kassirau");
		user.setPassword("0");
		user.setFirstname("Aliaksandr");
		user.setLastname("Kassirau");
		
		String generatedSessionId = UUID.randomUUID().toString();
		
		cacheManager.put(generatedSessionId, user, 10);
		
		
		User retrievedUser = (User) cacheManager.get(generatedSessionId);
		
		retrievedUser.getUsername();
	}
	
}
