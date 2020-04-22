package com.example.zerone.ems.controller;


import com.example.zerone.ems.exception.ResourceNotFoundException;
import com.example.zerone.ems.model.Employee;
import com.example.zerone.ems.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService emplyeeService;
   

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return this.emplyeeService.createEmployee(employee);
    }

    @GetMapping
    public Set<Employee> fetchEmployee(){
        return this.emplyeeService.fetchAllEmployees();
        		
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable long empId, @Valid @RequestBody Employee updateEmployee){
        return this.emplyeeService.updateEmployee(empId, updateEmployee);
        	
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployeeById(@PathVariable long empId){
        this.emplyeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeByEmployeeId(@PathVariable long empId) throws ResourceNotFoundException {
        System.out.println("Inside the get Employee by Employee id "+empId);
        return this.emplyeeService.findByEmployeeId(empId);
    }
}