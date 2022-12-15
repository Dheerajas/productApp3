package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	
	 Employee createEmployee(Employee employee);
	 List<Employee> findAllEmployee();
	 Employee findEmployeeById(int id);
//	Custom methods
	List<Employee> findByFirstName(String firstName);
	List<Employee> findByFirstNameContaining(String FirstName);
	List<Employee> findByFirstNameAndLastName(String firstName,String lastName);
	
	
	 void deleteEmployee(int id);
}
