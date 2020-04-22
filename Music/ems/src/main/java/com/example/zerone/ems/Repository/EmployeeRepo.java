package com.example.zerone.ems.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zerone.ems.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findAll();
}
