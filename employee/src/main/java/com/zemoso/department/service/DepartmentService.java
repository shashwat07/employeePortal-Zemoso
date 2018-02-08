package com.zemoso.department.service;

import com.zemoso.department.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DepartmentService {
    public List<Department> getAllDepartments();

}
