package com.cg.Evehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.Evehicle.model.User;



/**
 * UserDAO Interface
 * This interface have all methods related to User.
 * @author 15BW089AX
 *
 */
public interface UserDAO extends JpaRepository<User, Integer>{
	
	@Query("Select u from User u where u.email=:email")
	User findUserByEmail(String email);
	
}
