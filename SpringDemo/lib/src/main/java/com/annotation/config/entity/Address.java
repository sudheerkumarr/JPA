package com.annotation.config.entity;

import org.springframework.stereotype.Component;

@Component("addr")
public class Address {
	
	private String city;
	private String state;
	

	// Constructors
	public Address() {}
	
	public Address(String city) {
		super();
		this.city = city;
	}

	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	// Getters & setters
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
	
	

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	

}
