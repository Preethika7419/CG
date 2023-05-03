package com.cg.rent.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rent.dao.BookingDAO;
import com.cg.rent.dao.EnquiryDAO;
import com.cg.rent.dao.UserDAO;
import com.cg.rent.dao.VehicleDAO;
import com.cg.rent.exception.ResourceNotFoundException;
import com.cg.rent.model.Booking;
import com.cg.rent.model.Enquiry;
import com.cg.rent.model.User;
import com.cg.rent.model.Vehicle;
/**
 * UserService class :
 * This class handles all User related Services.
 * @author 15BW089AX
 *
 */

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	VehicleDAO vehicleDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	EnquiryDAO enquiryDAO;
	
	/**
	 * searchVehicleByBrand() :
	 * This method returns list of all vehicles with given brand.
	 * @param vbrand : String Vehicle Brand
	 * @return List<Vehicle> of Vehicles
	 */
	public List<Vehicle> searchVehicleByBrand(String vbrand)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in UserService - (searchVehicleByBrand)");
		List<Vehicle> list = vehicleDAO.findVehicleByBrand(vbrand);
		if(list.isEmpty())
			throw new ResourceNotFoundException("No Vehicle Found for brand "+vbrand);
		LOGGER.info("Done in UserService - (searchVehicleByBrand)");
		return list;
	}
	
	/**
	 * searchVehicleByType() :
	 * This method returns list of all vehicles with given type.
	 * @param vtype : String Vehicle Type
	 * @return List<Vehicle> of Vehicles
	 */
	public List<Vehicle> searchVehicleByType(String vtype)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in UserService - (searchVehicleByType)");
		List<Vehicle> list = vehicleDAO.findVehicleByType(vtype);
		if(list.isEmpty())
			throw new ResourceNotFoundException("No Vehicle Found for type "+vtype);
		LOGGER.info("Done in UserService - (searchVehicleByType)");
		return list;
	}
	
	/**
	 * bookVehicle() :
	 * This method books a vehicle for user.
	 * @param VId : int Vehicle Id
	 * @param UId : int User Id
	 * @return Booking instance
	 */
	public Booking bookVehicle(Booking booking) 
	{
		LOGGER.info("Entered in UserService - (bookVehicle)");
		Booking booking1 = bookingDAO.save(booking);
		LOGGER.info("Done in UserService - (bookVehicle)");
		return booking1;
	}
	
	/**
	 * createUser() : this method will store user instance in database.
	 * @param user
	 * @return User instance
	 */
	public User createUser(User user)
	{
		LOGGER.info("Entered in UserService - (createUser)");
		LOGGER.info("Done in UserService - (createUser)");
		return userDAO.save(user);
	}
	
	/**
	 * updateUser() :
	 * This method updated User in database.
	 * @param userId : int User Id
	 * @return Updated User instance
	 */
	public User updateUser(int userId, User user) 
	{
		LOGGER.info("Entered in UserService - (updateUser)");
		User userFromDB = userDAO.findById(userId).get();
		
		if(userFromDB!=null)
		{
			userFromDB.setName(user.getName());
			userFromDB.setEmail(user.getEmail());
			userFromDB.setAddress(user.getAddress());
			userFromDB.setContact(user.getContact());
			userFromDB.setPassword(user.getPassword());
			user = userDAO.save(userFromDB);
			//System.out.println(user);
			//System.out.println(userFromDB);
		}
		LOGGER.info("Done in UserService - (updateUser)");
		return user;
	}
	
	
	/**
	 * findUserByEmail()
	 * This method will return user instance with given mail
	 * @param email
	 * @return User instance
	 */
	public User findUserByEmail(String email)
	{
		LOGGER.info("Entered in UserService - (findUserByEmail)");
		User user = userDAO.findUserByEmail(email);
		LOGGER.info("Done in UserService - (findUserByEmail)");
		return user;
	}

	/**
	 * createEnquiry()
	 * This method will add Enquiry instance 
	 * @param Enquiry instance
	 * @return void
	 */
	@Override
	public Enquiry createEnquiry(Enquiry enquiry) 
	{
		LOGGER.info("Entered in UserService - (createEnquiry)");
		LOGGER.info("Done in UserService - (createEnquiry)");
		return enquiryDAO.save(enquiry);
	}
	
	/**
	 * fetchAllVheicle()
	 * This method will return list of all vehicle
	 * @return List of User 
	 */
	public List<Vehicle> fetchAllVehicle()
	{
		LOGGER.info("Entered in UserService - (fetchAllVehicle)");
		List<Vehicle> vehicleList = vehicleDAO.findAll();
		LOGGER.info("Done in UserService - (fetchAllVehicle)");
		return vehicleList;
	}
	
	/*
	 * findUserById()
	 * @return User instance
	 */
	public User findUserById(int id)
	{
		LOGGER.info("Entered in UserService - (findUserByEmail)");
		User user = userDAO.findById(id).get();
		LOGGER.info("Done in UserService - (findUserByEmail)");
		return user;
	}
	
	public Vehicle findVehicleById(int id)
	{
		LOGGER.info("Entered in UserService - (findVehicleById)");
		Vehicle vehicle = vehicleDAO.findById(id).get();
		LOGGER.info("Done in UserService - (findVehicleById)");
		return vehicle;
	}
	
	public Booking findBooking(int id)
	{
		LOGGER.info("Entered in UserService - (findBooking)");
		Booking booking = bookingDAO.findByUserId(id);
		LOGGER.info("Done in UserService - (findBooking)");
		return booking;
	}
}
