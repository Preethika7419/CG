package com.cg.rent.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import com.cg.rent.dao.VehicleDAO;
import com.cg.rent.exception.ResourceNotFoundException;
import com.cg.rent.model.Vehicle;
import static  org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {
	
	@MockBean
	VehicleDAO vehicleDAO;
	
	@Autowired
	AdminServiceImpl adminService;

	@Test
	public void testEditVehicle() throws ResourceNotFoundException{
		Vehicle vehicle = new Vehicle();
		vehicle.setVId(1);
		vehicle.setVbrand("Ford");
		vehicle.setVNumber("MH 12 034");
		vehicle.setVType("Car");
		
		Optional<Vehicle> optional = Optional.of(vehicle);
		
		Mockito.when(vehicleDAO.findById(1)).thenReturn(optional);
		assertThat(adminService.editVehicle(1, vehicle)).isEqualTo(optional.get());
		
	}
	
	@Test
	public void testRemoveVehicle() throws ResourceNotFoundException{


		Vehicle vehicle = new Vehicle();
		vehicle.setVId(29);
		vehicle.setVNumber("mh5678");
		vehicle.setVbrand("eicher");
		vehicle.setVType("truck");
		
		Optional<Vehicle> optional = Optional.of(vehicle);
		
		Mockito.when(vehicleDAO.findById(29)).thenReturn(optional);
		adminService.removeVehicle(29);
		verify(vehicleDAO, times(1)).findById(29);

	}

}
