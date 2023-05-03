package com.cg.Evehicle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.Evehicle.model.Vehicle;
import com.cg.Evehicle.service.VehicleServiceAdmin;

import java.util.List;

@RestController
@RequestMapping("/Vehicle/rest")
@CrossOrigin
public class VehicleRestController {

    @Autowired VehicleServiceAdmin vehicleService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Vehicle>> findAll(@RequestParam(value = "isFlag", required = false, defaultValue = "false") boolean isFlag) {
        List<Vehicle> users = vehicleService.findAllFilter(isFlag);
        System.out.println("VehicleDetails");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{vehicleId}")
    public void delete(@PathVariable int vehicleId) {
        vehicleService.delete(vehicleId);
    }
}
