package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profile {
	
	// Fields
	@Id
	@GeneratedValue
	private int profileId;
	private int age; 
	private double salary;
	
	@OneToOne(mappedBy="profile")
	private Employee employee;
	
	
	//Constructors
	public Profile() {}
	
	public Profile(int age, double salary) {
		super();
		this.age = age;
		this.salary = salary;
	}


	public Profile(int profileId, int age, double salary) {
		super();
		this.profileId = profileId;
		this.age = age;
		this.salary = salary;
	}

	// Getters & Setters
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", age=" + age + ", salary=" + salary + "]";
	}

	
	
	
	
	

}
