package com.cg.Evehicle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.Evehicle.model.Employee;
import com.cg.Evehicle.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/Employee/rest")
@CrossOrigin
public class EmployeeRestController {

    @Autowired EmployeeService employeeService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Employee>> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        List<Employee> users = employeeService.findAllFilter(isDeleted);
        System.out.println("Details");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employee_id}")
    public void delete(@PathVariable Long employee_id) {
        employeeService.delete(employee_id);
    }
}
