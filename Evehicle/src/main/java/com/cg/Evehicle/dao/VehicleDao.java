package com.cg.Evehicle.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.Evehicle.model.Vehicle;



	@Repository
	public interface VehicleDao extends JpaRepository<Vehicle,Integer>{
		@Query("select v from Vehicle v where v.category=:category")
		
		Iterable<Vehicle> findByCategory(String category);
		
		//@Query("select q.price from Vehicle q where q.vehicleId=:vehicleId")
//		Vehicle findByPrice(Integer vehicleId);
		
        Optional<Vehicle> findVehicleByPrice(Integer vehicleId);

		//Vehicle findVehicleByPrice(Integer vehicleId);

		

		
	}


