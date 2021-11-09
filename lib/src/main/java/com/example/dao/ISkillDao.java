package com.example.dao;

import com.example.entity.Skill;

public interface ISkillDao {

	Skill addSkill(Skill skill);
	void deleteSkill(int skillId);
	Skill getSkillById(int skillId);
}
