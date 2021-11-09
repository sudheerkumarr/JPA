package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Employee;
import com.example.entity.Profile;

public class ProfileDaoImpl implements IProfileDao{

	@Override
	public Profile addProfile(Profile profile) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(profile);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return profile;
	}

	@Override
	public void deleteProfile(int profileId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get profile by id
		Profile profile  = em.find(Profile.class, profileId);
		
		// remove profile
		em.remove(profile);
		
		// commit the changes
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public Profile updateProfile(int profileId, Profile profile) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get profile by id
		Profile dbProfile= em.find(Profile.class, profileId);
		
		// Update profile
		dbProfile.setAge(profile.getAge());
		dbProfile.setSalary(profile.getSalary());
		
		// save employee with updated details
		em.merge(dbProfile);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return dbProfile;
		
	}

	@Override
	public Profile getProfileById(int profileId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get emp by id
		Profile profile= em.find(Profile.class, profileId);
		
		em.close();
		emf.close();
		
		return profile;
		
	}

	@Override
	public List<Profile> getAllProfiles() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		List<Profile> profileList= em.createQuery("select p from Profile p").getResultList();
		
		em.close();
		emf.close();
		
		return profileList;
	
	}

}
