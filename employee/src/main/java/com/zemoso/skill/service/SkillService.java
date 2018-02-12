package com.zemoso.skill.service;

import com.zemoso.skill.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    public List<Skill> getAllSkills();
}
