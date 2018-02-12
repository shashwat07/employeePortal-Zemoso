package com.zemoso.skill.controller;

import com.zemoso.skill.model.Skill;
import com.zemoso.skill.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(method= RequestMethod.GET, value="/skills")
    @ResponseBody
    public ResponseEntity<Map> getAllProjects(){
        List<Skill> skills = skillService.getAllSkills();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("skills", skills);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}
