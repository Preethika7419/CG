package com.cg.rent.service;

import java.util.List;

import com.cg.rent.exception.ResourceNotFoundException;
import com.cg.rent.model.Booking;
import com.cg.rent.model.Enquiry;
import com.cg.rent.model.User;
import com.cg.rent.model.Vehicle;

/**
 * AdminService Interface 
 * This interface have all the methods related to Admin
 * @author 15BW089AX
 *
 */

public interface AdminService {
	
	public Vehicle createVehicle(Vehicle vehicle);

	public Vehicle editVehicle(int vId, Vehicle vehicle) throws ResourceNotFoundException ;
	
	public void removeVehicle(int vId) throws ResourceNotFoundException;
	
	public void confirmBooking(int eId);
	
	public List<User> fetchAllUser();
	
	public Booking fetchBookingById(int bId) throws ResourceNotFoundException;
	
	public void respondEnquiry(int eId, Enquiry enquiry);
}
