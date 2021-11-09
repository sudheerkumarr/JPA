package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.entity.Employee;
import com.example.entity.Profile;
import com.example.service.EmployeeServiceImpl;
import com.example.service.IEmployeeService;
import com.example.service.IProfileService;
import com.example.service.ProfileServiceImpl;

public class MyApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IEmployeeService empService = new EmployeeServiceImpl();
		IProfileService profileService = new ProfileServiceImpl();

		System.out.println("Select below options: ");
		System.out.println("1. Add Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. View Employee By Id");
		System.out.println("5. View Employee By Name");
		System.out.println("6. Update Employee By Name");
		System.out.println("7. View All Employee");

		System.out.println("8. Add Profile");
		System.out.println("9. Update employee profile");
		System.out.println("10. Add employee with profile");

		int selectedOption = sc.nextInt();

		switch (selectedOption) {
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
			// get emp id
			System.out.println("Enter empId ");
			int eId = sc.nextInt();

			// get emp name
			System.out.println("Enter emp name: ");
			String eName = sc.next();

			// get emp dept
			System.out.println("Enter emp dept name: ");
			String empDept = sc.next();

			// create emp obj
			Employee employee = new Employee(eId, eName, empDept);

			// update emp
			Employee updatedEmp = empService.updateEmployee(eId, employee);
			System.out.println(updatedEmp);
			break;
		case 3:
			System.out.println("Enter emp id: ");
			int i = sc.nextInt();
			empService.deleteEmployee(i);
			System.out.println("Deleted employee with id " + i + " successfully!");

			break;
		case 4:
			System.out.println("Enter emp id: ");
			int eId1 = sc.nextInt();
			Employee emp1 = empService.getEmployeeById(eId1);
			System.out.println(emp1);

			break;
		case 5:
			System.out.println("Enter employee name: ");
			String empName = sc.next();
			List<Employee> emps = empService.getEmployeeByName(empName);
			for (Employee e : emps) {
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
			List<Employee> empList = empService.getAllEmployees();
			Iterator<Employee> itr = empList.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}

			break;
		case 8:
			// Get emp age
			System.out.println("Enter age of an emp: ");
			int age = sc.nextInt();

			// get emp salary
			System.out.println("Enter emp Salary: ");
			double salary = sc.nextDouble();

			// create profile obj
			Profile profile = new Profile();

			// initialize profile properties
			profile.setAge(age);
			profile.setSalary(salary);

			// persist profile obj
			Profile profile1 = profileService.addProfile(profile);
			System.out.println(profile1);

			break;
		case 9:
			System.out.println("Enter emp id: ");
			int empId = sc.nextInt();

			System.out.println("Enter profile id: ");
			int profId = sc.nextInt();

			Employee uEmp = empService.updateProfile(empId, profId);
			System.out.println(uEmp);
			break;
		case 10:
			System.out.println("Enter your name: ");
			String name2 = sc.next();

			System.out.println("Enter dept name: ");
			String dept2 = sc.next();

			Employee emp2 = new Employee(name2, dept2);

			// Get emp age
			System.out.println("Enter age of an emp: ");
			int age2 = sc.nextInt();

			// get emp salary
			System.out.println("Enter emp Salary: ");
			double salary2 = sc.nextDouble();

			// create profile obj
			Profile profile2 = new Profile();

			// initialize profile properties
			profile2.setAge(age2);
			profile2.setSalary(salary2);
			
			// set emp profile
			emp2.setProfile(profile2);
			
			Employee result = empService.addEmployee(emp2);
			System.out.println("Added new emp "+name2+ " successfully! ");
			System.out.println(result);
			
			
			

			break;
		default:
			System.out.println("Enter any number between 1 and 7");
		}

	}

}
