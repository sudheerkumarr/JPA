package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	
	// Fields
	@Id
	@GeneratedValue
	private int skillId;
	private String skillName;
	
	
	@ManyToMany(mappedBy="skill")
	private List<Employee> employee = new ArrayList<>();
	
	// Constructor
	public Skill() {}
	public Skill(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	// Getters & Setters
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

}
