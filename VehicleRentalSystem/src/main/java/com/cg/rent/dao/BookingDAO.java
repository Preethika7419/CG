package com.cg.rent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.rent.model.Booking;

/**
 * BookingDAO interface
 * This class handles all the booking related database operations.
 * @author 15BW089AX
 *
 */
public interface BookingDAO extends JpaRepository<Booking, Integer>{
	@Query("Select b from Booking b where b.user.uId=:uId")
	Booking findByUserId(int uId);
}
