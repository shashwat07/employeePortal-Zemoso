package com.zemoso.skill.service;

import com.zemoso.skill.model.Skill;
import com.zemoso.skill.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return (List<Skill>)skillRepository.findAll();
    }
}
