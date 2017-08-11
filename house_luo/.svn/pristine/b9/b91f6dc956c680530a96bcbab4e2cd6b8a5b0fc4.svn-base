package com.qfedu.house.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.house.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-config/spring-app.xml" })
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testLogin() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		assertTrue(userService.login(user, "211.83.126.53"));
		assertEquals(user.getRealname(), "王大锤");
		assertTrue(user.getIsAdmin());
		user.setPassword("123123");
		assertFalse(userService.login(user, "209.115.13.7"));
		user.setUsername("hellokitty");
		assertFalse(userService.login(user, "10.10.10.1"));
	}
	
	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("oneshit");
		user.setPassword("1qaz2wsx");
		user.setRealname("李小屁");
		user.setTel("13500991234");
		user.setIsAdmin(false);
		assertTrue(userService.register(user));
		assertNotNull(user.getId());
	}
}
