package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * JPA(I) - Specification
 * Implementation classes of JPA
 *  Hibernate
 *  iBatis
 *  EclipseLink
 *  TopLink
 *   
 */

@Entity
//@Table(name="employee")
public class Employee {
	
	// variables
	@Id
	@GeneratedValue
	//@Column(name="emp_id")
	private int empId;
	
	
	//@Column(name="name")
	private String name;
	
	
	//@Column(name="dept")
	private String dept;
	
	
	// Constructors
	public Employee() {}
	
	
	
	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}



	public Employee(int empId, String name, String dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
	}


	// Getters & Setters
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
