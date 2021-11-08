package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImpl;
import com.example.service.IEmployeeService;

public class MyApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IEmployeeService empService = new EmployeeServiceImpl();
		
		System.out.println("Select below options: ");
		System.out.println("1. Add Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. View Employee By Id");
		System.out.println("5. View Employee By Name");
		System.out.println("6. Update Employee By Name");
		System.out.println("7. View All Employee");
		
		int selectedOption = sc.nextInt();
		
		switch(selectedOption) {
		case 1:
			System.out.println("Enter your name: ");
			String name = sc.next();
			
			System.out.println("Enter dept name: ");
			String dept = sc.next();
			
			Employee emp = new Employee(name, dept);
			
			Employee newEmp = empService.addEmployee(emp);
			System.out.println("Added employee successfully!");
			System.out.println(newEmp);
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			System.out.println("Enter employee name: ");
			String empName = sc.next();
			List<Employee> emps = empService.getEmployeeByName(empName);
			for(Employee e: emps) {
				System.out.println(e);
			}
			
			break;
		case 6:
			// get emp id
			System.out.println("Enter emp id: ");
			int id = sc.nextInt();
			
			// get name
			System.out.println("Enter new name: ");
			String n = sc.next();
			
			// update employee name 
			Employee e = empService.updateEmployeeName(id, n);
			
			// display updated name
			System.out.println(e);
			
			break;
		case 7:
			break;
		default:
			System.out.println("Enter any number between 1 and 7");
		}

	}

}
