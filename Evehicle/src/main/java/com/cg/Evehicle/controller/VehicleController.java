package com.cg.Evehicle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Evehicle.model.Vehicle;
import com.cg.Evehicle.service.VehicleService;


@RestController
@RequestMapping("user")
@CrossOrigin
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	
	
	@GetMapping("/getVehicle")
    public List<Vehicle> getVehicle(){
        return (List<Vehicle>) vehicleService.getVehicle();
    }
	
	@GetMapping("/getVehicleById/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable Integer vehicleId){
        return vehicleService.findVehicleById(vehicleId);
    }
	
	@GetMapping("/getVehicleByCategory/{category:.+}")
    public List<Vehicle> getVehicleByCategory(@PathVariable String category){
        return (List<Vehicle>) vehicleService.findVehicleByCategory(category);
    }
	@GetMapping("/calculation/{vehicleId}")
	public Optional<Vehicle> getCalculation(@PathVariable Integer vehicleId) {
		return vehicleService.findPrice(vehicleId);
	}
	


}
//