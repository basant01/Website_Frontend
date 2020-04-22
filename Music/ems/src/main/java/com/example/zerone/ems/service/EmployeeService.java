package com.example.zerone.ems.service;

import java.util.Set;

import com.example.zerone.ems.exception.ResourceNotFoundException;
import com.example.zerone.ems.model.Employee;



public interface EmployeeService {

	
	Employee createEmployee(Employee employee);
	
	Set<Employee> fetchAllEmployees();
	
Employee findByEmployeeId(long empId) throws ResourceNotFoundException;

Employee updateEmployee(long empId, Employee updateEmployee);
	
void deleteEmployeeById(long empId);

	
	
}
