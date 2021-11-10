package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.entity.Address;
import com.example.entity.Employee;

/*
 * Spring framework
 *  
 *  
 *  To develop JEE application
 *    EJB - Enterprise Java Beans
 *    Spring framework - 2003
 *     Test
 *     Core - IOC & DI
 *     Bean - 
 *     AOP
 *     WEB
 *   Light weight framework
 *   Easy test
 *   Loose coupling 
 *   open source
 *   Tomcat server
 *   
 *   new keyword - creating objects
 *   
 *   spring container - providing required beans
 *    Instantiation, adding dependencies
 *    
 *   Types Container
 *    1. BeanFactory(I)
           XmlBeanFactory(C)
           
     Resource resource=new ClassPathResource("applicationContext.xml");  
     BeanFactory factory=new XmlBeanFactory(resource);

      2. ApplicationContext(I) - build on top of BeanFactory
           ClassPathXmlApplicationContext(C) 
           
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
           
      
Ways to DI
----------
By Constructor
By Setter Method

 * Required JAR files
 * org.springframework.core-3.0.1.RELEASE-A
 * com.springsource.org.apache.commons.logging-1.1.1
 * org.springframework.beans-3.0.1.RELEASE-A
 *    
 *    
 *    
 *    Employee & Address
 *    
 *    
 *    // tightly coupled
 *    class Employee1{
 *       
 *         Address address;
 *         
 *         Employee1() {
 *           this.address = new Address2();
 *         } 
 *
 *     }
 *     
 *
 *     // loosely coupled
 *     class Employee2{
 *       
 *         Address address;
 *         
 *         Employee2(Address1 address) {
 *           this.address = address;
 *         } 
 *
 *      } 
 *      
 *      class Address1 {
 *      	String city;
 *      
 *          Address1() {}
 *          Address1(String city) {
 *            this.city = city;
 *          }
 *      }
 *      
 *      class Address2 {
 *      	String city;
 *      
 *      
 *          Address2() {}
 *          Address1(String city) {
 *            this.city = city;
 *          }
 *      }
 *      
 *      
 *      class Test {
 *      
 *         public static void main(String[] args) {
 *         		Employee1 emp = new Employee1();
 *             
 *             
 *              Address addr = new Address1();
 *              Employee2 emp = new Employee2(addr);
 *              
 *              
 *              Address addr = new Address2();
 *              Employee2 emp = new Employee2(addr);
 *         }
 *      }
 *      
 */
public class Test {

	public static void main(String[] args) {
		// 
		
		//Employee emp = new Employee("Ram");
		//System.out.println(emp.getName());
		
		//Address addr = new Address("", "");
		//Employee emp = new Employee(addr);

		
		// Getting beans using BeanFactory container
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);

	    Employee emp1 = (Employee) factory.getBean("emp1");
	    Employee emp2 = (Employee) factory.getBean("emp2");
	    
	    System.out.println(emp1.getEmpId());
	    System.out.println(emp1.getName());
	    
	    System.out.println(emp2.getEmpId());
	    System.out.println(emp2.getName());
	    

	    // Getting beans using ApplicationContext container 
	    ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext.xml");
	    
	    Employee emp3 = (Employee)context.getBean("emp1");
	    Employee emp4 = (Employee)context.getBean("emp2");
	    
	    System.out.println();
	    System.out.println(emp3.getEmpId());
	    System.out.println(emp3.getName());
	    
	    System.out.println(emp4.getEmpId());
	    System.out.println(emp4.getName());
	    
	    // Get address bean
	    Address addr1 = (Address)context.getBean("addr1");
	    Address addr2 = (Address)context.getBean("addr2");
	   
	    System.out.println();
	    System.out.println(addr1.getCity());
	    System.out.println(addr2.getCity());
	    
	    System.out.println(emp1.getAddress());
	    System.out.println(emp2.getAddress());
	    
	    System.out.println("Before: ");
	    System.out.println(emp1.getAddress().getCity());
	    
	    //emp1.setAddress(addr2);
	    
	    emp1.getAddress().setCity("Madurai");
	    System.out.println("After: ");
	    System.out.println(emp1.getAddress().getCity());
	    
	    
	    
		
	}

}
