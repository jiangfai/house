package com.qfedu.house.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.house.domain.User;
import com.qfedu.house.dto.UserDTO;

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
		UserDTO userDTO = new UserDTO();
		userDTO.setUser(user);
		userDTO.setIpAddress("211.83.126.53");
		assertTrue(userService.login(userDTO ));
		assertEquals(user.getRealname(), "王大锤");
		assertTrue(user.getIsAdmin());
		userDTO.getUser().setPassword("123123");
		assertFalse(userService.login(userDTO));
		userDTO.getUser().setUsername("hellokitty");
		assertFalse(userService.login(userDTO));
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
