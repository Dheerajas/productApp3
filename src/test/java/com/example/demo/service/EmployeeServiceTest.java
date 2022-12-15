package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Employee;
import com.example.demo.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

//	first method
//	@Test
//	public void createEmployeeTest() {
//		Employee employee=new Employee();
//		employee.setFirstName("Manish");
//		employee.setLastName("Mishra");
//		employee.setEmail("manish.se@gmail.com");
//		employee.setSalary(45000.0);
//		
//		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
//		
//		assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);
//	}

	@Test
	public void findAllEmployeeTest() {
//		need to injected 
	
	when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(211, "Ashish", "Senny", "ashish@gmail.com", 46000.0),
					new Employee(30, "Kashish", "Senny", "Kashish@gmail.com", 49000.0))
				.collect(Collectors.toList()));
//		expected result
		assertEquals(2, employeeService.findAllEmployee().size());
	}	

	@Test
	public void findByFirstName(){
		 String firstName="Manish";
		 when(employeeRepository.findByFirstName(firstName)).thenReturn(Stream
				.of(new Employee(211, "Manish", "Senny", "ashish@gmail.com", 46000.0))
				.collect(Collectors.toList()));
		 assertEquals(1, employeeService.findByFirstName(firstName).size());
		
	}
	
	
	@Test
	public void createEmployeeTest() {
		Employee employee=new Employee(30, "Kashish", "Senny", "Kashish@gmail.com", 49000.0);
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		assertEquals(employee,employeeService.createEmployee(employee));
	}
	
	
	@Test
	public void deleteEmployeeTest() {
		int id=23;
		employeeService.deleteEmployee(id);
	    verify(employeeRepository,times(1)).deleteById(id);
	}
	
	
//	public void  findEmployeeByIdTest() {
//		Employee employee=new Employee();
//	
//		employee.setId(1);
//		employee.setFirstName("Manish"); 
//		employee.setLastName("Mishra");
//		employee.setEmail("manish.se@gmail.com");
//		employee.setSalary(45000.0);
//		
//		Mockito.when(employeeRepository.findById(1)).thenReturn(employee);
//		
//		assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);
//	}

}
