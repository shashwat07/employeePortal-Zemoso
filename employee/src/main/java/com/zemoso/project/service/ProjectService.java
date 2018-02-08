package com.zemoso.project.service;

import com.zemoso.project.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public List<Project> getAllProjects();
}
