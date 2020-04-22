package com.example.zerone.ems.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;

@Entity
@Table(name = "employee_line_leave")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(exclude = "emp")
@EqualsAndHashCode()
public class EmployeeLineLeave extends AuditModel{

	
	EmployeeLineLeave(){}
	
	@Id
    @GeneratedValue(strategy = AUTO)
	private long leaveId;
	
	private String leaveReason;
	private String comments;


	

	@Column(name = "startDate")
	    @JsonProperty("startDate")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	    private LocalDate startDate;
	 
	 @Column(name = "endDate")
	    @JsonProperty("endDate")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	    private LocalDate endDate;

	  @ManyToOne
	    @JoinColumn(name="empId", nullable = false)
	    @JsonIgnore
	    private Employee emp;
	  
	 
	  
    public long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}



	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	 public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}