package com.example.entity;

import java.util.List;

public class Employee {
	
	// Fields
	private int empId;
	private String name;
	
	private Address address;
	
	private List<String> contactNos;
	
	// Constructor
	public Employee() {}
	
	public Employee(int empId) {
		super();
		this.empId = empId;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	

	public Employee(int empId, String name, Address address, List<String> contactNos) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.contactNos = contactNos;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getContactNos() {
		return contactNos;
	}

	public void setContactNos(List<String> contactNos) {
		this.contactNos = contactNos;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
