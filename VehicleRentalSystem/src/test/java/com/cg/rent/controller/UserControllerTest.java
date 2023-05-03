package com.cg.rent.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
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
import com.cg.rent.model.Login;
import com.cg.rent.model.User;
import com.cg.rent.model.Vehicle;
import com.cg.rent.service.UserManagementServiceImpl;
import com.cg.rent.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserManagementServiceImpl userManager;

	@MockBean
	UserServiceImpl userService;

	@Test
	public void testNewUser() throws Exception{
		String URI = "/user/newUser";
		User user = new User();
		user.setEmail("test1@gmail.com");
		user.setName("Test1");
		user.setAddress("test1 address");
		user.setContact("5678954367");
		user.setRole("User");
		user.setPassword("test123");

		String jsonInput = this.converttoJson(user);
		//{"id":"101,j......."}
		Mockito.when(userManager.registerUser(Mockito.any(User.class))).thenReturn(user);

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonInput)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	public void testGetVehicleByBrand() throws Exception{
		String URI = "/user/vehicleByBrand/{brand}";
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVId(1);
		vehicle1.setVbrand("Audi");
		vehicle1.setVNumber("MH 12 4567");
		vehicle1.setVType("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVId(2);
		vehicle2.setVbrand("Audi");
		vehicle2.setVNumber("MH 06 6734");
		vehicle2.setVType("Car");


		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);

		String jsonInput = this.converttoJson(vehicleList);

		Mockito.when(userService.searchVehicleByBrand(Mockito.any())).thenReturn(vehicleList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "Audi")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	public void testGetVehicleByType() throws Exception{
		String URI = "/user/vehicleByType/{type}";
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVId(1);
		vehicle1.setVbrand("Audi");
		vehicle1.setVNumber("MH 12 4567");
		vehicle1.setVType("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVId(2);
		vehicle2.setVbrand("Audi");
		vehicle2.setVNumber("MH 06 6734");
		vehicle2.setVType("Car");


		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);

		String jsonInput = this.converttoJson(vehicleList);

		Mockito.when(userService.searchVehicleByType(Mockito.any())).thenReturn(vehicleList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "Car")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	public void testGetAllVehicle() throws Exception{
		String URI = "/user/getAllVehicles";
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVId(1);
		vehicle1.setVbrand("Audi");
		vehicle1.setVNumber("MH 12 4567");
		vehicle1.setVType("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVId(2);
		vehicle2.setVbrand("Honda");
		vehicle2.setVNumber("MH 06 6734");
		vehicle2.setVType("Truck");

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVId(2);
		vehicle3.setVbrand("BMW");
		vehicle3.setVNumber("MH 45 6345");
		vehicle3.setVType("Car");

		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);
		vehicleList.add(vehicle3);

		String jsonInput = this.converttoJson(vehicleList);

		Mockito.when(userService.fetchAllVehicle()).thenReturn(vehicleList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}


	@Test
	public void testLogin() throws Exception
	{   
		String URI = "/user/login";
		Login login = new Login();
		login.setEmail("dhanashree@gmail.com");
		login.setPassword("5678");
		
		String result = "Welcome Dhanashree\nYour User Id :1";

		Mockito.when(userManager.login(Mockito.any())).thenReturn(result);
		String jsonInput = this.converttoJson(login);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonInput)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertThat(result).isEqualTo(jsonOutput);

	}


	/**
	 * Convert Object into Json String by using Jackson ObjectMapper
	 * @param user
	 * @return
	 * @throws JsonProcessingException
	 */
	private String converttoJson(Object user) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(user);
	}


}
