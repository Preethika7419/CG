package com.cg.rent.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.junit.Test;
import org.junit.runner.RunWith;
import static  org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.rent.dao.UserDAO;
import com.cg.rent.model.Login;
import com.cg.rent.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementServiceImplTest {

	@MockBean
	UserDAO userDAO;

	@Autowired
	UserManagementServiceImpl userManager;

	@Test
	public void testRegisterUser(){
		User user = new User();
		user.setEmail("test1@gmail.com");
		user.setName("Test1");
		user.setAddress("test1 address");
		user.setContact("5678954367");
		user.setRole("User");
		user.setPassword("test123");

		Mockito.when(userDAO.save(user)).thenReturn(user);
		assertThat(userManager.registerUser(user)).isEqualTo(user);
	}

	@Test
	public void testLogin()
	{
		User user = new User();
		user.setUId(1);
		user.setEmail("dhanashree@gmail.com");
		user.setName("Dhanashree");
		user.setAddress("test1 address");
		user.setContact("5678954367");
		user.setRole("User");
		user.setPassword("5678");

		Login login = new Login();
		login.setEmail("dhanashree@gmail.com");
		login.setPassword("5678");

		Mockito.when(userDAO.findUserByEmail(login.getEmail())).thenReturn(user);

		userManager.login(login);
		verify(userDAO, times(1)).findUserByEmail("dhanashree@gmail.com");

		assertEquals("Welcome Dhanashree\nYour User Id :1",userManager.login(login));
	}

	@Test
	public void testFalsePasswordLogin()
	{
		User user = new User();
		user.setEmail("dhanashree@gmail.com");
		user.setName("Dhanashree");
		user.setAddress("test1 address");
		user.setContact("5678954367");
		user.setRole("User");
		user.setPassword("5678");

		Login login = new Login();
		login.setEmail("dhanashree@gmail.com");
		login.setPassword("test");

		Mockito.when(userDAO.findUserByEmail(login.getEmail())).thenReturn(user);

		assertEquals("Please Enter Correct Password",userManager.login(login));
	}

	@Test
	public void testFalseUserNameLogin()
	{
		User user = null;

		Login login = new Login();
		login.setEmail("dhanashree@gmail.com");
		login.setPassword("test");

		Mockito.when(userDAO.findUserByEmail(login.getEmail())).thenReturn(user);
		assertEquals("Please Enter correct Email",userManager.login(login));
	}

}
