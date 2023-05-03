package com.cg.rent.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * AdminService class :
 * This class handles all Admin related Services
 * 
 * @author 15BW089AX
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger LOGGER = LogManager.getLogger(AdminServiceImpl.class);
	
	@Autowired
	VehicleDAO vehicleDAO;
	
	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	EnquiryDAO enquiryDAO;
	
	/**
	 * ceateVehicle()
	 * This method accepts vehicle instance  
	 * And stores it in database
	 * @param Vehicle instance
	 * @return void
	 */
	public Vehicle createVehicle(Vehicle vehicle) 
	{
		LOGGER.info("Entered in AdminService - (createVehicle)");
		LOGGER.info("Done in AdminService - (createVehicle)");
		return vehicleDAO.save(vehicle);
	}
	
	/**
	 * editVehicle() 
	 * This method edits details of given vehicle Id
	 * @param int VId
	 * @param Vehicle instance
	 * @return Vehicle instance
	 */
	public Vehicle editVehicle(int vehicleId, Vehicle vehicle)throws ResourceNotFoundException 
	{
		LOGGER.info("Entered in AdminService - (editVehicle)");
		Vehicle vehicleFromDB = vehicleDAO.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle is not present."));
		vehicleFromDB.setVbrand(vehicle.getVbrand());
		vehicleFromDB.setVType(vehicle.getVType());
		vehicleFromDB.setVNumber(vehicle.getVNumber());
		vehicleFromDB.setImage(vehicle.getImage());
		vehicleDAO.save(vehicleFromDB);
		LOGGER.info("Done in AdminService - (editVehicle)");
		return vehicleFromDB;
	}
	
	/**
	 * removeVehicle()
	 * This method will remove Vehicle from database having given Id
	 * @param VId : int Vehicle Id
	 * @return void
	 */
	public void removeVehicle(int vehicleId)throws ResourceNotFoundException
	{
		LOGGER.info("Entered in AdminService - (removeVehicle)");
		Vehicle vehicle = vehicleDAO.findById(vehicleId)
		.orElseThrow(() -> new ResourceNotFoundException("Vehicle is not present."));

		vehicleDAO.delete(vehicle);
		LOGGER.info("Done in AdminService - (removeVehicle)");
	}
	
	/**
	 * confirmBooking()
	 * This method will confirm booking.
	 * @param int BId
	 */
	public void confirmBooking(int bookingId)
	{
		LOGGER.info("Entered in AdminService - (confirmBooking)");
		 Optional<Booking> bookOptional = bookingDAO.findById(bookingId);
		 Booking booking = bookOptional.get();
		 booking.setStatus(1);
		 bookingDAO.save(booking); 
		 LOGGER.info("Done in AdminService - (confirmBooking)");
	}
	
	/**
	 * fetchUser()
	 * This method will return list of all users
	 * @return List of User 
	 */
	public List<User> fetchAllUser()
	{
		LOGGER.info("Entered in AdminService - (fetchAllUsers)");
		List<User> userlist = userDAO.findAll();
		LOGGER.info("Done in AdminService - (fetchAllUsers)");
		return userlist;
	}
	
	/**
	 * getUserId() : This method will return User by Id
	 * @param UId
	 * @return User instance
	 * @throws ResourceNotFoundException 
	 */
	public User getUserById(int userId) throws ResourceNotFoundException
	{
		LOGGER.info("Entered in AdminService - (getUserById)");
		
		User user = userDAO.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User is not present for id "+userId));
		
		LOGGER.info("Done in AdminService - (getUserById)");
		return user;
	}
	
	/**
	 * fetchBookingById()
	 * This method will search booking by Id
	 * @param BId int Booking Id
	 * @return Booking Instance
	 * @throws ResourceNotFoundException 
	 */
	public Booking fetchBookingById(int bookingId) throws ResourceNotFoundException
	{
		LOGGER.info("Entered in AdminService - (fetchBookingById)");
		Booking booking = bookingDAO.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking is not available for id "+bookingId));
		
		LOGGER.info("Done in AdminService - (fetchBookingById)");
		return booking;
	}
	
	/**
	 * respondEnquiry()
	 * This method will give response to enquiry
	 * @param int EId
	 * @param Enquiry instance
	 * @return void
	 */
	public void respondEnquiry(int enquiryId, Enquiry enquiry)
	{
		LOGGER.info("Entered in AdminService - (respondEnquiry)");
		Enquiry enquiry1 = enquiryDAO.findById(enquiryId).get();
		if(enquiry1!=null)
		enquiry1.setResponse(enquiry.getResponse());
		enquiryDAO.save(enquiry1);
		LOGGER.info("Done in AdminService - (respondEnquiry)");
	}

	/**
	 * finfVehicleById()
	 * This method will return vehicle with given Id
	 * @param vehicleId
	 * @return Vehicle instance
	 */
	public Vehicle findVehicleById(int vehicleId)
	{
		LOGGER.info("Entered in AdminService - (findVehicleById)");
		LOGGER.info("Done in AdminService - (findVehicleById)");
		return vehicleDAO.findById(vehicleId).get();
	}

	/**
	 * fetchAllBookings()
	 * This method will return all bookings
	 * @return List of Bookings
	 */
	public List<Booking> fetchAllBookings() 
	{
		LOGGER.info("Entered in AdminService - (fetchAllBookings)");
		LOGGER.info("Done in AdminService - (fetchAllBookings)");
		return bookingDAO.findAll();
	}
	
	/**
	 * fetchAllVhicle()
	 * This method will return list of all vehicle
	 * @return List of User 
	 */
	public List<Vehicle> fetchAllVehicle()
	{
		LOGGER.info("Entered in AdminService - (fetchAllVehicle)");
		List<Vehicle> vehicleList = vehicleDAO.findAll();
		LOGGER.info("Done in AdminService - (fetchAllVehicle)");
		return vehicleList;
	}
	
	/**
	 * findUserByEmail()
	 * This method will return user instance with given mail
	 * @param email
	 * @return User instance
	 */
	public User findUserByEmail(String email)
	{
		LOGGER.info("Entered in AdminService - (findUserByEmail)");
		User user = userDAO.findUserByEmail(email);
		LOGGER.info("Done in AdminService - (findUserByEmail)");
		return user;
	}
}
