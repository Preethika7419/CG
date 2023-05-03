package com.cg.Evehicle.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Evehicle.dao.BookDao;
import com.cg.Evehicle.dao.VehicleDao;
import com.cg.Evehicle.exception.ResourceNotFoundException;
import com.cg.Evehicle.model.Book;



@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private BookDao bookDao;
	

//	@Override
//	public Book createBooking(Book book) {
//		return bookDao.save(book);
//	}


	@Override
	public  Book createBookingById(Integer vehicleId, Book book) {
		
		return vehicleDao.findById(vehicleId).map(vehicle->{
			book.setVehicle(vehicle);
			return bookDao.save(book);
			
		}).orElseThrow(()-> new ResourceNotFoundException("Vehicle Id"+vehicleId+"not found"));
			
	}
	
	
	
	

}
