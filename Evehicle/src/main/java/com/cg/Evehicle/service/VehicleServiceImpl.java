package com.cg.Evehicle.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Evehicle.dao.VehicleDao;
import com.cg.Evehicle.exception.ResourceNotFoundException;
import com.cg.Evehicle.model.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
	
		@Autowired
		private VehicleDao vehicleDao;
		
		@Override
		public Iterable<Vehicle> getVehicle() {
			return  vehicleDao.findAll();
		}
		
		@Override
		public Vehicle findVehicleById(Integer vehicleId) {
			return vehicleDao.findById(vehicleId).map(getting->{
			getting.setVehicleId(vehicleId);
				return vehicleDao.save(getting);
			}).orElseThrow(()-> new ResourceNotFoundException("Vehicle Id "+vehicleId+" not found"));

			
		}

		@Override
		public Iterable<Vehicle> findVehicleByCategory(String category) {
			
			return (Iterable<Vehicle>) vehicleDao.findByCategory(category);
				
		}

		@Override
		public Optional<Vehicle> findPrice(Integer vehicleId) {
			
			return  vehicleDao.findVehicleByPrice(vehicleId);
		}

		
		
		

		

//		@Override
//		public Vehicle findPrice(Integer vehicleId) {
//			
//			return vehicleDao.findByPrice(vehicleId);
//		}
						
			
		
//		@Override
//		public Book findBookById(Integer orderId) {
//			return dealerDao.findById(orderId).map(gettingbooking->{
//				gettingbooking.setOrderId(orderId);
//				return dealerDao.save(gettingbooking);
//				}).orElseThrow(()-> new ResourceNotFoundException("Order Id "+orderId+" not found"));
//		}

		
		
		
}
