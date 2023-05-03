package com.cg.Evehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.Evehicle.model.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	//public List<String> findByCategory(String Category);

}

// JpaRepository