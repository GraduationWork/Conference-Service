package com.conference.dataprovider.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-context.xml" })
@Transactional
@Rollback(false)
public class HibernateRolesTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testInsert() {
		List<Role> roles = sessionFactory.getCurrentSession().createCriteria(Role.class).list();
		for(Role role: roles) {
			System.out.println(role.getRole());
		}
	}
	
}
