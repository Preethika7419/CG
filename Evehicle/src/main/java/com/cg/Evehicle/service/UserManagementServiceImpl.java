package com.cg.Evehicle.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Evehicle.dao.UserDAO;
import com.cg.Evehicle.model.Login;
import com.cg.Evehicle.model.User;


/**
 * UserManagementService class :
 * This class performs User specific operations 
 * @author 15BW089AX
 *
 */
@Service
@Transactional
public class UserManagementServiceImpl {
	
	
	
	@Autowired
	UserDAO userDAO;
	
	/**
	 * registerUser() :
	 * This method accepts user instance and store them in database
	 * @param User instance
	 * @return void 
	 */
	public User registerUser(User user) 
	{
		
		return userDAO.save(user);
	}
	
	
	public void changePassword(int userId, User user) 
	{
		
		Optional<User> userOptional = userDAO.findById(userId);
		User user1 = userOptional.get();
		if(user1!=null)
			userDAO.save(user);
		
	}
	
	/**
	 * login() :
	 * This method validates password and email from database.
	 * @return String 
	 */
	public String login(Login login)
	{
		
		String result = "";
		
		User user = userDAO.findUserByEmail(login.getEmail());
		if(user!=null)
		{
			if(user.getPassword().equals(login.getPassword()))
			{
				result = "Welcome "+ user.getName()+"\nYour User Id :"+user.getUId();
				if(user.getRole().equalsIgnoreCase("Admin"))
				{
					//String masterPass = login.getMasterPassword();
					//if(masterPass.equals("AdminPass"))
					result="Welcome Admin "+user.getName();
				}
			}
			else
				result = "Please Enter Correct Password";
		}
		else
			result = "Please Enter correct Email";
		
		return result; 
	}
	
	public void logout(String email)
	{
		
	}
}
