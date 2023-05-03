package com.cg.Evehicle.controller;


	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	import org.junit.Assert;
	import org.junit.jupiter.api.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.mock.web.MockHttpServletResponse;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.MvcResult;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.Evehicle.model.Book;
import com.cg.Evehicle.service.BookService;
import com.cg.Evehicle.service.EvehicleServiceTest;
import com.cg.Evehicle.service.VehicleService;
import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	 
	@RunWith(SpringRunner.class)
	@WebMvcTest(value =BookController.class)

	public class BookControllerTest {
		
		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private BookService bookService;


		
		@Test
		void testcreateBookingById() throws Exception{
			String URI ="/api/v1//createBookingById/{vehicleId}";
			Book book = new Book();
			book.setOrderId(2);
			book.setUname("sandeep");
			book.setEmail("sandeep@gmail.com");
			book.setContact((long) 987776889);
			book.setQuantity(2);
			String jsonInput = this.converttoJson(book);
			
			Mockito.when(bookService.createBookingById(null,Mockito.any(Book.class))).thenReturn(book);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			assertThat(jsonInput).isEqualTo(jsonOutput);
			Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			
		}
//		Mockito.when(supplierService.findBySupplierUserNameAndPassword(supplier1.getSupplierUserName(),
//				supplier1.getPassword())).thenReturn(supplier1);
		
		
//		@Test
//		void testGetSupplierById() throws Exception {
//			String URI = "/api/v1/getById/{supplierUserName}";
//			Supplier supplier = new Supplier();
//			supplier.setSupplierName("kumar");
//			supplier.setSupplierUserName("kumar01");
//			supplier.setSupplierAddress("Chennai");
//			supplier.setSupplierContactNumber(987776769);
//			supplier.setPassword("kumar!");
//			supplier.setConfirmPassword("kumar!");
//			String jsonInput = this.converttoJson(supplier);
//			Optional<Supplier> supplier1 = Optional.of(supplier);
//
//			Mockito.when(supplierService.getSupplierById(supplier.getSupplierUserName())).thenReturn(supplier1);
//			MvcResult mvcResult = this.mockMvc
//					.perform(MockMvcRequestBuilders.get(URI, "kumar01").accept(MediaType.APPLICATION_JSON)).andReturn();
//			MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//			String jsonOutput = mockHttpServletResponse.getContentAsString();
//			assertThat(jsonInput).isEqualTo(jsonOutput);
//
//		}


		private String converttoJson(Object book) throws JsonProcessingException{
			ObjectMapper objectMapper= new ObjectMapper();
			return objectMapper.writeValueAsString(book);
		}
		
		
		
		

	}


