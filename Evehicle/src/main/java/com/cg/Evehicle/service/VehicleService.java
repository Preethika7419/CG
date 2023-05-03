package com.cg.Evehicle.service;


import java.util.Optional;

import com.cg.Evehicle.model.Vehicle;

public interface VehicleService {

		Iterable<Vehicle> getVehicle();
		
		
		 Vehicle findVehicleById(Integer vehicleId);

		Iterable<Vehicle> findVehicleByCategory(String category);


		Optional<Vehicle> findPrice(Integer vehicleId);


		

		

		

		
}
