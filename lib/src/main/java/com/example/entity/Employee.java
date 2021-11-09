package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * JPA(I) - Specification
 * Implementation classes of JPA
 *  Hibernate
 *  iBatis
 *  EclipseLink
 *  TopLink
 *   
 *   
 * Relationships
 *  
 *  OneToMany
 *  ManyToOne
 *  ManyToMany 
 *  
 *     
 *     
 *     
 *  OneToOne Example
 *   Employee - Profile
 *   
 *   One Employee - One Profile
 *   One Profile - One Employee 
 *   
 *   
 * ManyToMany Example
 *  Employee - Skill
 *   One Employee - Many Skills
 *   One Skill - Many Employees
 *
 *  Employee - Address
 *    One Employee Many Address
 *    One Address One Employee
 *    One Address Many Employee
 *    
 *  Cart & Items
 *    One Cart - Many Items
 *    One Item - Many Carts
 *    
 *  Book & Author
 *    One Book - Many Authors
 *    One Author - Many Books
 
 *   
 * OneTo Many
 *   Employee - Department
 *    One Emp - One Dept
 *    One Dept - Many Emp
 *    
 *   Employee - ContactNo
 *    One Emp - Many contact nos
 *    One Contact - One Emp
 *    
 *   Employee - Vehicle
 *     One Emp - Many Vehicle
 *     One Vehi - One Emp
 *     
 *  
 *  
 *  Directions
 *  UniDirectional 
 *  BiDirectional
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private Profile profile;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
	private List<Address> address;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
        name = "employee_skills", 
        joinColumns = { @JoinColumn(name = "emp_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
	private List<Skill> skill = new ArrayList<>();
	
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Skill> getSkill() {
		return skill;
	}



	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", profile=" + profile + "]";
	}	
	

}
