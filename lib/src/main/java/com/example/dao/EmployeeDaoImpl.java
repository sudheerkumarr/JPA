package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	
	// insert
	@Override
	public Employee addEmployee(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(employee);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return employee;
	}

	//delete
	@Override
	public void deleteEmployee(int empId) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get emp by id
		Employee emp= em.find(Employee.class, empId);
		
		// remove employee
		em.remove(emp);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		
	}

	//update
	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get emp by id
		Employee dbEmp= em.find(Employee.class, empId);
		
		// Update employee
		dbEmp.setName(employee.getName());
		dbEmp.setDept(employee.getDept());
		
		// save employee with updated details
		em.persist(dbEmp);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return dbEmp;
	}

	//read
	@Override
	public Employee getEmployeeById(int empId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get emp by id
		Employee emp= em.find(Employee.class, empId);
		
		em.close();
		emf.close();
		
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
				
		// Get emp by name
		//Employee emp= em.find(Employee.class, empName);
		Query q = em.createQuery("select e from Employee e where e.name=:empName"); // JPQL Query
		
		
		em.close();
		emf.close();
	
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.createQuery("select e from Employee e");
		
		em.close();
		emf.close();
		
		return null;
	}

	// update name
	@Override
	public Employee updateEmployeeName(int empId, String newName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get emp by id
		Employee dbEmp= em.find(Employee.class, empId);
		
		em.getTransaction().begin();
		
		// Update employee name
		dbEmp.setName(newName);
		
		// save emp in db
		em.persist(dbEmp);
		
		em.getTransaction().commit();
		
		return dbEmp;
	}

	

}
