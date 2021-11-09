package com.example.dao;

import java.util.List;

import com.example.entity.Profile;

public interface IProfileDao {

	Profile addProfile(Profile profile);
	void deleteProfile(int profileId);
	Profile updateProfile(int profileId, Profile profile);
	Profile getProfileById(int profileId);
	List<Profile> getAllProfiles();
}
