package com.example.zerone.ems.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;
import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "employee")
@ToString
@EqualsAndHashCode(of = "empId")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends AuditModel{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    @JsonProperty("empId")
    private long empId;

    @Column(name = "doj")
    @JsonProperty("doj")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private LocalDate doj;

    @Column(name="empName")
    @JsonProperty("empName")
    @NotEmpty(message = "name must not be empty")
    private String empName;
    
    @Column(name="empEmail")
    @JsonProperty("empEmail")
    private String empEmail;
	
    @OneToMany(mappedBy = "emp",
            fetch = LAZY,
            cascade = {PERSIST, REMOVE})
    @JsonProperty("line_leaves")
    @Column(name = "line_leaves")
    private Set<EmployeeLineLeave> employeeLineLeave;



	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

    public Set<EmployeeLineLeave> getEmployeeLineLeave() {
		return employeeLineLeave;
	}

	public void setEmployeeLineLeave(Set<EmployeeLineLeave> employeeLineLeave) {
		this.employeeLineLeave = employeeLineLeave;
	}
    
    
	   public void addEmployeeLineLeave(EmployeeLineLeave employeeleave){
	        this.employeeLineLeave.add(employeeLeave);
	        employeeLeave.setEmp(this);
	    }
   
}