package com.annotation.config.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	// Fields
	private int empId;
	private String name;
	
	// Field Injection
	@Autowired
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
	
	// @Autowired - Constructor injection
	public Employee(Address address) {
		this.address = address;
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

	// Setter Injection
	//@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getContactNos() {
		return contactNos;
	}

	public void setContactNos(List<String> contactNos) {
		this.contactNos = contactNos;
	}

	public void display() {
		System.out.println();
		System.out.println(address.getCity());
		System.out.println(address.getState());
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
