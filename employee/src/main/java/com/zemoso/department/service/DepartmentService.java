package com.zemoso.department.service;


import com.zemoso.department.model.Department;
import com.zemoso.department.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

    /*@Autowired
    private DepartmentRepository departmentRepository;*/

    private List<Department> departments = Arrays.asList(
            new Department(1,"Business"),
            new Department(2,"Marketing"),
            new Department(3,"Operations"),
            new Department(4,"Technology"),
            new Department(5,"Human Resource")
    );

    public List<Department> getAllDepartments(){
        /*List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);*/
        return departments;
    }

}
