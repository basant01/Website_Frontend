package com.example.zerone.ems.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zerone.ems.Repository.EmployeeRepo;
import com.example.zerone.ems.exception.ResourceNotFoundException;
import com.example.zerone.ems.model.Employee;
import com.example.zerone.ems.model.EmployeeLineLeave;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeRepo employeeRepo;
	
	
	@Override
	public Employee createEmployee(Employee emp) {
		 System.out.println("Inside the save method of Order service .... :: ");
	        System.out.println(emp);
	        for(EmployeeLineLeave employeeLineLeave: emp.getEmployeeLineleave()) {
	        	employeeLineLeave.setEmp(emp);
	        }
	        return this.employeeRepo.save(emp);
	        }

	@Override
	public Set<Employee> fetchAllEmployees() {
		 return new HashSet<>(this.employeeRepo.findAll());
	}

	@Override
	public Employee findByEmployeeId(long empId) throws ResourceNotFoundException {
		return this.employeeRepo
                .findById(empId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found"));
	}

	@Override
	public Employee updateEmployee(long empId, Employee updateEmployee) {
		return updateEmployee;
		
	}

	@Override
	public void deleteEmployeeById(long empId) {
		this.employeeRepo.deleteById(empId);
		
	}

}
