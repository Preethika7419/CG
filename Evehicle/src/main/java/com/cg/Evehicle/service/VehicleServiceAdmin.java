package com.cg.Evehicle.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Evehicle.dao.VehicleRepository;
import com.cg.Evehicle.model.Vehicle;

import org.hibernate.Filter;
import org.hibernate.Session;
//defining the business logic

@Service
public class VehicleServiceAdmin {

	@Autowired
 	VehicleRepository vehicleRepository;
	@Autowired
	EntityManager entityManager;
	
//getting all Vehicle record by using the method findaAll() of CrudRepository

	public List<Vehicle> getAllVehicle() {
		System.out.println("getAllVehicleDetails");
       	List<Vehicle> vehicle = new ArrayList<Vehicle>();
       	vehicleRepository.findAll().forEach(vehicle1 -> vehicle.add(vehicle1));
       	return vehicle;
 	}
 
//getting a specific record by using the method findById() of CrudRepository

	public Vehicle getVehicleById(int id) {
		System.out.println("getVehicleById");
       	return vehicleRepository.findById(id).get();
 	}
	
/*
 public List<String> getVehicleByCategory(String Category){
 	System.out.println("getVehicleByCategory");
 	return vehicleRepositry.findByCategory(Category);
 }
 */
 
//saving a specific record by using the method save() of CrudRepository
 	public void saveOrUpdate(Vehicle vehicle) {
 		System.out.println("saveOrUpdate");
       	vehicleRepository.save(vehicle);
 	}
 
//deleting a specific record by using the method deleteById() of CrudRepository
 	public void delete(int id) {
 		System.out.println("delete");
       	vehicleRepository.deleteById(id);
 	}
 
//updating a record
 	public void update(Vehicle vehicle, int vehicle_id) {
 		System.out.println("updateVehicleDetails");
       	vehicleRepository.save(vehicle);
 	}
 	
 	//filter records
	  public List<Vehicle> findAllFilter(boolean isFlag) {
	        Session session = entityManager.unwrap(Session.class);
	        Filter filter = session.enableFilter("deletedVehicleFilter");
	        filter.setParameter("isFlag", isFlag);
	        List<Vehicle> vehicles = vehicleRepository.findAll();
	        session.disableFilter("deletedVehicleFilter");
	        return vehicles;
	    }
}
