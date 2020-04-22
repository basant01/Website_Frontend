package com.example.zerone.ems.service;

import java.util.List;

import com.example.zerone.ems.exception.EmployeeLineleaveNotFoundException;
import com.example.zerone.ems.model.EmployeeLineLeave;

public interface EmployeeLineLeaves {

	EmployeeLineLeave saveEmployeeLineLeave(EmployeeLineLeave leave);
	

	EmployeeLineLeave updateEmployeeLineLeave(long leaveId,EmployeeLineLeave leave);


	  
	    List<EmployeeLineLeave> fetchAllEmployeeLineLeave();

	  
	    EmployeeLineLeave findEmployeeLineLeaveById(long leaveId) throws EmployeeLineleaveNotFoundException;
	
	    void deleteEmployeeLineLevaeById(long leaveId);

}
