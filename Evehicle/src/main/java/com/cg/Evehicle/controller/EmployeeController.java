package com.cg.Evehicle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import org.springframework.http.ResponseEntity;

import com.cg.Evehicle.model.Employee;
import com.cg.Evehicle.service.EmployeeService;


//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
/*
import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
*/
//mark class as Controller
@RestController
@CrossOrigin
public class EmployeeController {
//Autowire the EmployeeService class
	
	@Autowired
	EmployeeService employeeService;

//creating a get mapping that retrieves all the Employee detail from the database

	@GetMapping("/Employee")
	private List<Employee> getAllEmployee() {
		System.out.println("getAllEmployee");
		return employeeService.getAllEmployee();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/Employee/{employee_id}")
	private Employee getEmployee(@PathVariable("employee_id") long employee_id) {
	
		System.out.println("getEmployeeDetails");
		return employeeService.getEmployeeById(employee_id);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/Employee/{employee_id}")
	private void deleteEmployee(@PathVariable("employee_id") int employee_id) {
		System.out.println("deleteEmployee");
		employeeService.delete(employee_id);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/Employee")
	private long saveEmployee(@RequestBody Employee Employee) {
		System.out.println("saveEmployee");
		employeeService.saveOrUpdate(Employee);
		return Employee.getEmployee_id();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/Employee")
	private Employee update(@RequestBody Employee Employee) {
		System.out.println("update");
		employeeService.saveOrUpdate(Employee);
		return Employee;
	}

}
