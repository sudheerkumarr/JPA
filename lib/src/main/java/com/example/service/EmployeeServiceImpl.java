package com.example.service;

import java.util.List;

import com.example.dao.EmployeeDaoImpl;
import com.example.dao.IEmployeeDao;
import com.example.entity.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	

	IEmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = empDao.addEmployee(employee);
		return emp;
	}

	@Override
	public void deleteEmployee(int empId) {
		empDao.deleteEmployee(empId);

	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		Employee emp = empDao.updateEmployee(empId, employee);
		return emp;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Employee emp = empDao.getEmployeeById(empId);
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		List<Employee> empList = empDao.getEmployeeByName(empName);
		return empList;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = empDao.getAllEmployees();
		return empList;
	}

	@Override
	public Employee updateEmployeeName(int empId, String newName) {
		return empDao.updateEmployeeName(empId, newName);
	}

	

}
