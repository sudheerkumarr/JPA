package com.example.service;

import com.example.entity.Skill;

public interface ISkillService {
	Skill addSkill(Skill skill);
	Skill getSkillById(int skillId);
	void deleteSkill(int skillId);

}
