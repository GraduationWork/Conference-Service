package com.conference.dataprovider.hibernate;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Role;
import com.conference.core.domain.RolesEnum;
import com.conference.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-context.xml" })
@Transactional
@Rollback(false)
public class HibernateUsersTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testInsert() {
//		User user = new User();
//		user.setUsername("aliaksandr_kassirau2");
//		user.setEmail("aliaksandr.kassirau@gmail.com");
//		user.setFirstname("Aliaksandr");
//		user.setIsActive(true);
//		user.setLastname("Kassirau");
//		user.setPassword("0");
//		Role role = new Role();
//		user.setRoles(Arrays.asList(role));
//		role.setRole(RolesEnum.ROLE_CONFERENCE_USER.toString());
//		
//		sessionFactory.getCurrentSession().save(user);
		User retrievedUser = (User) sessionFactory.getCurrentSession().createCriteria(User.class).list().get(0);
		retrievedUser.getIsActive();
	}
	
}
