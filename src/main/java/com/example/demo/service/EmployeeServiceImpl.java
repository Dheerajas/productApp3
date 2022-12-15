package com.example.demo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public 
	Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	public 
	List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public 
	Employee findEmployeeById(int id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			System.out.println("no data found in DB(throw the error)");
		}
		return null;
	}

	@Override
	public
	List<Employee> findByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> findByFirstNameContaining(String FirstName) {
		return employeeRepository.findByFirstNameContaining(FirstName);
		
	}

	@Override
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	

	
	

}
