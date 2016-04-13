package com.conference.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conference.dataprovider.domain.User;
import com.conference.services.common.IUserVerifierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context.xml" })
public class UserMailVerifierTest {

	@Autowired
	private IUserVerifierService verifierService;
	
	@Test
	public void test() {
		User user = new User();
		user.setEmail("aliaksandr.kassirau@gmail.com");
		user.setUsername("aliaksandr_kassirau");
		verifierService.sendVerification(user);
	}
	
}
