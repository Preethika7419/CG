package com.cg.Evehicle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.Evehicle.model.Book;
import com.cg.Evehicle.service.DealerService;

@RestController
@RequestMapping("Dealer")
@CrossOrigin
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
	
	
	
	@GetMapping("/getBooking")
    public List<Book> getBooking(){
        return (List<Book>) dealerService.getBooking();
    }
	
	
	@GetMapping("/getOrderById/{orderId}")
    public Book getOrderById(@PathVariable Integer orderId){
        return dealerService.findBookById(orderId);
        
	}
	

	
	@RequestMapping(value="/DealerMessage", method=RequestMethod.GET) 
	@ResponseBody 
	public String display(HttpServletResponse response) { 
	response.setContentType("text/plain"); 	 response.setCharacterEncoding("UTF-8"); 
	return "Thankyou for your Order!!! \n  Have a Safe Journey "; 
	} 
	
//	.map(gettingbooking->{
//		gettingbooking.setOrderId(orderId);
//		return dealerDao.save(gettingbooking);
//		}).orElseThrow(()-> new ResourceNotFoundException("Order Id "+orderId+" not found"));

	


}
