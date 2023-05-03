package com.cg.rent.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rent.exception.ResourceNotFoundException;
import com.cg.rent.model.Booking;
import com.cg.rent.model.Login;
import com.cg.rent.model.User;
import com.cg.rent.model.Vehicle;
import com.cg.rent.service.AdminServiceImpl;
import com.cg.rent.service.UserManagementServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	UserManagementServiceImpl userManager;
	
	private static final Logger LOGGER = LogManager.getLogger(AdminController.class);
	
	/**
	 * adminLogin()
	 * To validate admin email and password.
	 * @param login
	 * @return String message
	 */
	@PostMapping("/login")
	ResponseEntity<?> adminLogin(@RequestBody Login login)
	{
		LOGGER.info("Entered in Admin Controller - (login)");
		String result = userManager.login(login);
		User user = adminService.findUserByEmail(login.getEmail());
		LOGGER.info("Done in Admin Controller - (login)");
		if(result.contains("User"))
			return new ResponseEntity<String>("Sorry!! You are not admin", HttpStatus.BAD_REQUEST);
		if(result.contains("Please"))
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * createAdmin() : This function will save admin instance in database
	 * @param user
	 * @return User instance
	 */
	@PostMapping("/newAdmin")
	User createAdmin(@Valid @RequestBody User admin)
	{
		LOGGER.info("Entered in Admin Controller - (newAdmin)");
		LOGGER.info("Done in Admin Controller - (newAdmin)");
		return userManager.registerUser(admin);
	}
	
	
	/**
	 * To fetch all user.
	 * @return List of Users
	 */
	@GetMapping("/getAllUsers")
	public List<User> getUsers()
	{
		LOGGER.info("Entered in Admin Controller - (getUsers)");
		LOGGER.info("Done in Admin Controller - (getUsers)");
		return adminService.fetchAllUser();
	}
	
	
	/**
	 * getUserById() :
	 *  This method will return user instance corresponding to given id
	 * @param userId
	 * @return User insatnce
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getUserById/{uId}")
	User getUserById(@PathVariable("uId") int userId) throws ResourceNotFoundException
	{
		LOGGER.info("Entered in Admin Controller - (getUserById)");
		LOGGER.info("Done in Admin Controller - (getUserById)");
		return adminService.getUserById(userId);
	}
	
	/**
	 * To create vehicle. 
	 * @param vehicle
	 * @return Vehicle instance
	 */
	@PostMapping("/saveVehicle")
	public Vehicle saveVehicle(@RequestBody final Vehicle vehicle)
	{
		LOGGER.info("Entered in Admin Controller - (saveVehicle)");
		LOGGER.info("Done in Admin Controller - (saveVehicle)");
		return adminService.createVehicle(vehicle);
	}
	
	/**
	 * To delete vehicle by id.
	 * @param vehicleId
	 */
	@DeleteMapping("/deleteVehicle/{vId}")
	public String deleteVehicle(@PathVariable("vId") int vehicleId)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in Admin Controller - (deleteVehicle)");
		adminService.removeVehicle(vehicleId);
		LOGGER.info("Done in Admin Controller - (deleteVehicle)");
		return "Vehicle deleted Successfully!!";
	}
	
	/**
	 * To edit Vehicle by Id.
	 * @param vehicleId
	 * @param vehicle
	 * @return Vehicle instance
	 */
	@PutMapping("/updateVehicle/{vId}")
	public Vehicle updateVehicle(@PathVariable("vId") int vehicleId, @RequestBody Vehicle vehicle)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in Admin Controller - (updateVehicle)");
		LOGGER.info("Done in Admin Controller - (updateVehicle)");
		return adminService.editVehicle(vehicleId, vehicle);
	}
	
	/**
	 * getAllBooking() 
	 * To get list of all bookings
	 * @return List Of booking
	 */
	@GetMapping("/getBookings")
	List<Booking> getAllBooking()
	{
		LOGGER.info("Entered in Admin Controller - (getBookings)");
		LOGGER.info("Done in Admin Controller - (getBookings)");
		return adminService.fetchAllBookings();
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
		LOGGER.info("Entered in Admin Controller - (getVehicleByType)");
		List<Vehicle> list = adminService.fetchAllVehicle();
		LOGGER.info("Done in Admin Controller - (getVehicleByType)");
		return new ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);
	}
}
