package com.emp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String fname;
	private String lname;
	private String department;
	private Date dateofbirth;
	private String gender;

	public Employee(Long empId, String fname,String lname, String department,Date date,String gender) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.department = department;
		this.dateofbirth=date;
		this.gender=gender;
	}

	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public Employee() {
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Long getEmpId() {
		return empId;
	}

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
