package com.zemoso.project.controller;

import com.zemoso.project.model.Project;
import com.zemoso.project.service.ProjectService;
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
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method= RequestMethod.GET, value="/projects")
    @ResponseBody
    public ResponseEntity<Map> getAllProjects(){
        List<Project> projects = projectService.getAllProjects();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("projects", projects);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
