package com.cg.rent.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.rent.dao.UserDAO;
import com.cg.rent.model.Login;
import com.cg.rent.model.User;

/**
 * UserManagementService class :
 * This class performs User specific operations 
 * @author 15BW089AX
 *
 */
@Service
@Transactional
public class UserManagementServiceImpl {
	
	private static final Logger LOGGER = LogManager.getLogger(UserManagementServiceImpl.class);
	
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
		LOGGER.info("Entered in UserManagementService - (createUser)");
		LOGGER.info("Done in UserManagementService - (createUser)");
		return userDAO.save(user);
	}
	
	/**
	 * changePassword() :
	 * This method accepts new password and update it in database
	 * @param  int UId User Id
	 * @return void
	 */
	public void changePassword(int userId, User user) 
	{
		LOGGER.info("Entered in UserManagementService - (changePassword)");
		Optional<User> userOptional = userDAO.findById(userId);
		User user1 = userOptional.get();
		if(user1!=null)
			userDAO.save(user);
		LOGGER.info("Done in UserManagementService - (changePassword)");
	}
	
	/**
	 * login() :
	 * This method validates password and email from database.
	 * @return String 
	 */
	public String login(Login login)
	{
		LOGGER.info("Entered in UserManagementService - (login)");
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
		LOGGER.info("Done in UserManagementService - (login)");
		return result; 
	}
	
	public void logout(String email)
	{
		
	}
}
