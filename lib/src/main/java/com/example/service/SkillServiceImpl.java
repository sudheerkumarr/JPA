package com.example.service;

import com.example.dao.ISkillDao;
import com.example.dao.SkillDaoImpl;
import com.example.entity.Skill;

public class SkillServiceImpl implements ISkillService{

	ISkillDao skillDao = new SkillDaoImpl();
	
	@Override
	public Skill addSkill(Skill skill) {
		return skillDao.addSkill(skill);
	}

	@Override
	public void deleteSkill(int skillId) {
		
		
	}

	@Override
	public Skill getSkillById(int skillId) {
		
		return skillDao.getSkillById(skillId);
	}

}
