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

import com.cg.Evehicle.model.Vehicle;
import com.cg.Evehicle.service.VehicleServiceAdmin;



//mark class as Controller
@RestController
@CrossOrigin
public class VehicleControllerAdmin {
//autowire the EmployeeService class 
	@Autowired
	VehicleServiceAdmin vehicleService;

//creating a get mapping that retrieves all the Employee detail from the database

	@GetMapping("/Vehicle")
	private List<Vehicle> getAllVehicle() {
		System.out.println("getAllVehicle");
		return vehicleService.getAllVehicle();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/Vehicle/{vehicleId}")
	private Vehicle getVehicle(@PathVariable("vehicleId") int vehicleId) {
		System.out.println("getVehicle");
		return vehicleService.getVehicleById(vehicleId);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/Vehicle/{vehicleId}")
	private void deleteVehicle(@PathVariable("vehicleId") int vehicleId) {
		System.out.println("deleteVehicle");
		vehicleService.delete(vehicleId);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/Vehicle")
	private int saveEmployee(@RequestBody Vehicle vehicle) {
		System.out.println("saveVehicleDetails");
		vehicleService.saveOrUpdate(vehicle);
		return vehicle.getVehicleId();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/Vehicle")
	private Vehicle update(@RequestBody Vehicle vehicle) {
		System.out.println("updateVehicleDetails");
		vehicleService.saveOrUpdate(vehicle);
		return vehicle;
	}
}
