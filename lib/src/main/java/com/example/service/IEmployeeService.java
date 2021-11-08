package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface IEmployeeService {
	
	Employee addEmployee(Employee employee);
	void deleteEmployee(int empId);
	Employee updateEmployee(int empId, Employee employee);
	Employee getEmployeeById(int empId);
	List<Employee> getEmployeeByName(String empName);
	List<Employee> getAllEmployees();
	Employee updateEmployeeName(int empId, String newName);
	

}
