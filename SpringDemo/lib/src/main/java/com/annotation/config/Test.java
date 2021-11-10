package com.annotation.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.annotation.config.entity.Address;
import com.annotation.config.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		// Read Spring config file
		ApplicationContext context =
						  new ClassPathXmlApplicationContext("applicationContext.xml");
	
		
		// Get employee bean from spring container
		Employee emp = (Employee) context.getBean("employee");
		
		// print employee details
		System.out.println(emp.getEmpId()); // 0
		System.out.println(emp.getName()); // null
		System.out.println(emp.getAddress()); // null
		System.out.println(emp.getContactNos()); //null
		
		// Get address bean from spring container
		Address address = (Address) context.getBean("addr");
		
		// Initialize emp properties
		emp.setEmpId(1002);
		emp.setName("Kavita");
		
		address.setCity("Chennai");
		address.setState("TN");
	
		emp.setAddress(address);
		
		List<String> contactNos = new ArrayList<>();
		contactNos.add("9999911111");
		contactNos.add("9999911112");
		contactNos.add("9999911113");
		
		emp.setContactNos(contactNos);
		
	
		// display employee details
		System.out.println(emp.getEmpId());  
		System.out.println(emp.getName()); 
		System.out.println(emp.getAddress()); 
		System.out.println(emp.getContactNos()); 
		
		emp.display();
		
		
		
		
	}

}
