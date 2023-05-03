package com.cg.rent.controller;

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
import com.cg.rent.exception.ResourceNotFoundException;
import com.cg.rent.model.Booking;
import com.cg.rent.model.Enquiry;
import com.cg.rent.model.Login;
import com.cg.rent.model.User;
import com.cg.rent.model.Vehicle;
import com.cg.rent.service.UserManagementServiceImpl;
import com.cg.rent.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	UserManagementServiceImpl userManager;
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	/**
	 * getVehicleByBrand() : This method will list the vehicles by brand
	 * @param brand
	 * @return List of Vehicle
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/vehicleByBrand/{brand}")
	ResponseEntity<List<Vehicle>> getVehicleByBrand(@PathVariable("brand") String brand)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (getVehicleByBrand)");
		List<Vehicle> list = userService.searchVehicleByBrand(brand);
		LOGGER.info("Done in User Controller - (getVehicleByBrand)");
		return new ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);
	}

	/**
	 * getVehicleByType() : This method will list vehicles by type.
	 * @param type
	 * @return List of vehicle
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/vehicleByType/{type}")
	ResponseEntity<List<Vehicle>> getVehicleByType(@PathVariable("type") String type) throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (getVehicleByType)");
		List<Vehicle> list = userService.searchVehicleByType(type);
		LOGGER.info("Done in User Controller - (getVehicleByType)");
		return new ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);
	}
	
	/**
	 * getAllVehicle() : This method will list all vehicles.
	 * @param type
	 * @return List of vehicle
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getAllVehicles")
	ResponseEntity<List<Vehicle>> getAllVehicle() throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (getVehicleByType)");
		List<Vehicle> list = userService.fetchAllVehicle();
		LOGGER.info("Done in User Controller - (getVehicleByType)");
		return new ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);
	}
	
	/**
	 * userLogin() : This method performs login operation
	 * @param login
	 * @return String Message
	 */
	@PostMapping("/login")
	ResponseEntity<?> userLogin(@RequestBody Login login)
	{
		LOGGER.info("Entered in User Controller - (login)");
		String result = userManager.login(login);
		LOGGER.info("Done in User Controller - (login)");
		if(result.contains("Please"))
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		else
		{
			User user = userService.findUserByEmail(login.getEmail());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	/**
	 * createUser() : This function will save user instance in database
	 * @param user
	 * @return User instance
	 */
	@PostMapping("/newUser")
	ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		LOGGER.info("Entered in User Controller - (createUser)");
		User newUser = userManager.registerUser(user);
		LOGGER.info("Done in User Controller - (createUser)");
		if(newUser==null)
			return new ResponseEntity<Object>("User cannot be saved",HttpStatus.BAD_REQUEST);
		else 
			return new ResponseEntity<Object>(user,HttpStatus.OK);
	}
	
	/**
	 * bookVehicle() : This method will add booking in database
	 * @param booking
	 * @return
	 */
	@PostMapping("/bookVehicle")
	ResponseEntity<String> bookVehicle(@RequestBody Booking booking)
	{
		LOGGER.info("Entered in User Controller - (bookVehicle)");
		LOGGER.info("Done in User Controller - (bookVehicle)");
		if(userService.bookVehicle(booking)!=null)
			return new ResponseEntity<String>("Vehicle is booked Successfully..",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Vehicle is not booked",HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * updateUser() : This method will update user 
	 * @param userId
	 * @param user
	 * @return User instance
	 */
	@PutMapping("/updateUser/{UID}")
	User updateUser(@PathVariable("UID") int userId, @RequestBody User user)
	{
		LOGGER.info("Entered in User Controller - (updateUser)");
		LOGGER.info("Done in User Controller - (updateUser)");
		return userService.updateUser(userId, user);
	}
	
	/**
	 * addEnquiry() : This method add user enquiry
	 * @param enquiry
	 */
	@PostMapping("/addEnquiry")
	ResponseEntity<String> addEnquiry(@RequestBody Enquiry enquiry)
	{
		LOGGER.info("Entered in User Controller - (addEnquiry)");
		LOGGER.info("Done in User Controller - (addEnquiry)");
		if(userService.createEnquiry(enquiry)!=null)
			return new ResponseEntity<String>("Enquiry added Successfully... ",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Enquiry is not added",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getUser/{id}")
	ResponseEntity<User> getUser(@PathVariable("id") int id)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (findById)");
		User user = userService.findUserById(id);
		LOGGER.info("Done in User Controller - (findById)");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getVehicle/{id}")
	ResponseEntity<Vehicle> getVehicle(@PathVariable("id") int id)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (findByVehicleId)");
		Vehicle vehicle = userService.findVehicleById(id);
		LOGGER.info("Done in User Controller - (findByVehicleId)");
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
	
	@GetMapping("/getBooking/{id}")
	ResponseEntity<Booking> getBooking(@PathVariable("id") int id)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in User Controller - (findBooking)");
		Booking booking = userService.findBooking(id);
		LOGGER.info("Done in User Controller - (findBooking)");
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
}
