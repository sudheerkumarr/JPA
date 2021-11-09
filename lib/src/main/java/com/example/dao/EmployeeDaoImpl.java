package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Employee;
import com.example.entity.Profile;

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
		em.merge(dbEmp);
		
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
		Query q = em.createQuery("select e from Employee e where e.name=:name"); // JPQL Query
		q.setParameter("name", empName);
		
		List<Employee> empList = q.getResultList();
		
		em.close();
		emf.close();
	
		return empList;
	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		List<Employee> empList= em.createQuery("select e from Employee e").getResultList();
		
		em.close();
		emf.close();
		
		return empList;
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

	@Override
	public Employee updateProfile(int empId, int profileId) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get emp by id
		Employee dbEmp= em.find(Employee.class, empId);
		
		// Get profile by id 
		Profile dbProfile = em.find(Profile.class, profileId);
		
		em.getTransaction().begin();
		
		// Update employee profile
		dbEmp.setProfile(dbProfile);
		
		// update emp in db
		em.merge(dbEmp);
		
		em.getTransaction().commit();
		
		return dbEmp;
		
	}

	

}
