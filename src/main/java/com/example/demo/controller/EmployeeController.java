package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/demo")
	public String test() {
		return "tommy";
	}
	
	@PostMapping
	public Employee createEmp(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id")int id){
		return employeeService.findEmployeeById(id);
	}
	
	@GetMapping("/findByFirstName")
	public ResponseEntity<List<Employee>> getEmployeeByFirstName(@RequestParam(required = false) String firstName){
		try {
		      List<Employee> employees = new ArrayList<Employee>();

		      if (firstName == null)
		    	  employeeService.findAllEmployee().forEach(employees::add);
		      else
		    	  employeeService.findByFirstNameContaining(firstName).forEach(employees::add);

		      if (employees.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(employees, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@GetMapping("/findByFirstNameAndLastName")
	public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLastName(@RequestParam(required = false) String firstName,@RequestParam(required = false) String lastName){
		try {
		      List<Employee> employees = new ArrayList<Employee>();

		      if (firstName == null && lastName==null)
		    	  employeeService.findAllEmployee().forEach(employees::add);
		      else
		    	  employeeService.findByFirstNameContaining(firstName).forEach(employees::add);

		      if (employees.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(employees, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	
}
