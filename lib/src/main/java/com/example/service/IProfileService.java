package com.example.service;

import java.util.List;

import com.example.entity.Profile;

public interface IProfileService {
	
	Profile addProfile(Profile profile);
	void deleteProfile(int profileId);
	Profile updateProfile(int profileId, Profile profile);
	Profile getProfileById(int profileId);
	List<Profile> getAllProfiles();
	

}
