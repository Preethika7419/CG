package com.cg.Evehicle.dao;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.Evehicle.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}

// JpaRepository