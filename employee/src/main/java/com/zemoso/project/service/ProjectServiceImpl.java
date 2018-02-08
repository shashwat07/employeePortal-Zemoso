package com.zemoso.project.service;

import com.zemoso.location.model.Location;
import com.zemoso.location.repo.LocationRepository;
import com.zemoso.project.model.Project;
import com.zemoso.project.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return (List<Project>)projectRepository.findAll();
    }
}
