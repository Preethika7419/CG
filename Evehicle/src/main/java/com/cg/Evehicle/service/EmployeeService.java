package com.cg.Evehicle.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.Evehicle.dao.EmployeeRepository;
import com.cg.Evehicle.model.Employee;

import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
//defining the business logic
@Service
public class EmployeeService {

	@Autowired(required=true)
 	EmployeeRepository employeeRepository;
	@Autowired
	EntityManager entityManager;
 
//getting all Employee record by using the method findaAll() of CrudRepository

	public List<Employee> getAllEmployee() {
		System.out.println("getAllEmployee");
       	List<Employee> employee = new ArrayList<Employee>();
       	employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
       	return employee;
 	}
 
//getting a specific record by using the method findById() of CrudRepository

	public Employee getEmployeeById(long id) {
		System.out.println("getEmployeeById");
       	return employeeRepository.findById(id).get();
 	}
 
//saving a specific record by using the method save() of CrudRepository
 	public void saveOrUpdate(Employee employee) {
 		System.out.println("saveOrUpdate");
       	employeeRepository.save(employee);
 	}
 
//deleting a specific record by using the method deleteById() of CrudRepository
 	public void delete(long id) {
 		System.out.println("delete");
       	employeeRepository.deleteById(id);
 	}
 
//updating a record
 	public void update(Employee employee, int eid) {
 		System.out.println("update");
       	employeeRepository.save(employee);
 	}
 	
 	//filter records
 	  public List<Employee> findAllFilter(boolean isDeleted) {
 	        Session session = entityManager.unwrap(Session.class);
 	        Filter filter = session.enableFilter("deletedEmployeeFilter");
 	        filter.setParameter("isDeleted", isDeleted);
 	        List<Employee> employees = employeeRepository.findAll();
 	        session.disableFilter("deletedEmployeeFilter");
 	        return employees;
 	    }
}