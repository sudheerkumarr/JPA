package com.example.service;

import java.util.List;

import com.example.dao.IProfileDao;
import com.example.dao.ProfileDaoImpl;
import com.example.entity.Profile;

public class ProfileServiceImpl implements IProfileService{

	IProfileDao profDao = new ProfileDaoImpl();
	
	
	@Override
	public Profile addProfile(Profile profile) {
		return profDao.addProfile(profile);
	}

	@Override
	public void deleteProfile(int profileId) {
		profDao.deleteProfile(profileId);
		
	}

	@Override
	public Profile updateProfile(int profileId, Profile profile) {
		return profDao.updateProfile(profileId, profile);
	}

	@Override
	public Profile getProfileById(int profileId) {
		return profDao.getProfileById(profileId);
	}

	@Override
	public List<Profile> getAllProfiles() {
		return profDao.getAllProfiles();
	}

}
