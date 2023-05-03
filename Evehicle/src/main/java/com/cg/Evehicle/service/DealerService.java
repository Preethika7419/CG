package com.cg.Evehicle.service;



import com.cg.Evehicle.model.Book;

public interface DealerService {
	Iterable<Book> getBooking();
	

	// ResponseEntity<String> findBookById(Integer orderId);
	 Book findBookById(Integer orderId);

	//Iterable<Book> findBookByVId(Integer vehicleId);
	 //String methodname();


}
