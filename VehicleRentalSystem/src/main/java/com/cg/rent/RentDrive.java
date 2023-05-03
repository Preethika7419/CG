package com.cg.rent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.rent.controller.AdminController;

@SpringBootApplication
public class RentDrive {
	
	private static final Logger LOGGER = LogManager.getLogger(AdminController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RentDrive.class, args);
		
		LOGGER.info("Rent Drive App Started");
	}

}
