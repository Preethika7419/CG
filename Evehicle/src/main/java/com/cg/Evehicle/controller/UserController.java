package com.cg.Evehicle.controller;

import java.util.List;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Evehicle.exception.ResourceNotFoundException;
import com.cg.Evehicle.model.Book;
import com.cg.Evehicle.model.Login;
import com.cg.Evehicle.model.User;
import com.cg.Evehicle.service.UserManagementServiceImpl;
import com.cg.Evehicle.service.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	UserManagementServiceImpl userManager;
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	

	@PostMapping("/login")
	ResponseEntity<?> userLogin(@RequestBody Login login)
	{
		
		String result = userManager.login(login);
		
		if(result.contains("Please"))
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		else
		{
			User user = userService.findUserByEmail(login.getEmail());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/newUser")
	ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User newUser = userManager.registerUser(user);
		
		if(newUser==null)
			return new ResponseEntity<Object>("User cannot be saved",HttpStatus.BAD_REQUEST);
		else 
			return new ResponseEntity<Object>(user,HttpStatus.OK);
	}
	
	
//	@PostMapping("/bookVehicle")
//	ResponseEntity<String> bookVehicle(@RequestBody Booking booking)
//	{
//		LOGGER.info("Entered in User Controller - (bookVehicle)");
//		LOGGER.info("Done in User Controller - (bookVehicle)");
//		if(userService.bookVehicle(booking)!=null)
//			return new ResponseEntity<String>("Vehicle is booked Successfully..",HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Vehicle is not booked",HttpStatus.BAD_REQUEST);
//	}
	
	@GetMapping("/getUser/{id}")
	ResponseEntity<User> getUser(@PathVariable("id") int id)throws ResourceNotFoundException
	{
		
		User user = userService.findUserById(id);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	
//	@PostMapping("/createBookingById/{vehicleId}")
//    public Book createBookingById(@PathVariable(value="vehicleId") Integer vehicleId,@RequestBody Book book) {
//        return bookService.createBookingById(vehicleId,book);
//
//    }
	
	
		
	
	
	
}
