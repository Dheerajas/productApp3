package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	 List<Employee> findByFirstName(String firstName);
	 List<Employee> findByFirstNameContaining(String FirstName);
	 
	 List<Employee> findByFirstNameAndLastName(String firstName,String lastName); 
}
