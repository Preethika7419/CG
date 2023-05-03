package com.cg.Evehicle.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Evehicle.model.Book;
import com.cg.Evehicle.service.BookService;



@RestController
@RequestMapping("user")
@CrossOrigin
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/createBookingById/{vehicleId}")
    public Book createBookingById(@PathVariable(value="vehicleId") Integer vehicleId,@RequestBody Book book) {
        return bookService.createBookingById(vehicleId,book);

    }
	@RequestMapping(value="/BookingMessage", method=RequestMethod.GET) 
	@ResponseBody 
	public String display(HttpServletResponse response) { 
	response.setContentType("text/plain"); 	 response.setCharacterEncoding("UTF-8"); 
	return "Booked Successfully....\n You Can download your Order details....\nYour dealer will contact you.."; 
	} 
	
//	@GetMapping("/calculation")
//	public ResponseEntity<String> calculation(@RequestBody Vehicle vehicle){
//		Vehicle vehicle1=VechilceSe}
		
		
	
	




	
}
