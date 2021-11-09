package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	// Fields
	@Id
	@GeneratedValue
	private int addrId;
	private String city;
	private String state;
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	// Constructors
	public Address() {}
	
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public Address(int addrId, String city, String state) {
		super();
		this.addrId = addrId;
		this.city = city;
		this.state = state;
	}


	// Getters & Setters
	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", city=" + city + ", state=" + state + "]";
	}	

}
