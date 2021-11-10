package com.javabased.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabased.config.entity.Address;
import com.javabased.config.entity.AppConfig;
import com.javabased.config.entity.Employee;

public class Test {

	public static void main(String[] args) {

		// Create application context container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Get emp & address beans from container
		Employee emp = context.getBean(Employee.class);
		Address address = context.getBean(Address.class);
		
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getAddress());
		System.out.println(emp.getContactNos());

		// Initialize emp properties
		emp.setEmpId(1002);
		emp.setName("Kavita");

		// Initialize address properties
		address.setCity("Chennai");
		address.setState("TN");

		// set emp address
		emp.setAddress(address);

		List<String> contactNos = new ArrayList<>();
		contactNos.add("9999911111");
		contactNos.add("9999911112");
		contactNos.add("9999911113");

		// add contact numbers
		emp.setContactNos(contactNos);
		
		System.out.println();
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getAddress());
		System.out.println(emp.getContactNos());

	}

}
