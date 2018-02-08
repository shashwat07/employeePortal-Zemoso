package com.zemoso.department.service;

import com.zemoso.department.model.Department;
import com.zemoso.department.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return (List<Department>)departmentRepository.findAll();
    }
}
