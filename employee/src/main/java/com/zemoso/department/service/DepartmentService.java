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

    @Autowired
    private DepartmentRepository departmentRepository;

    public void initialize(){
        List<Department> depts = Arrays.asList(
                new Department(1,"Business"),
                new Department(2,"Marketing"),
                new Department(3,"Operations"),
                new Department(4,"Technology"),
                new Department(5,"Human Resource")
        );

        for (Department dep : depts){
            departmentRepository.save(dep);
        }
    }

    public List<Department> getAllDepartments(){
        List<Department> departmentList = new ArrayList<>();
        for(Department dept : departmentRepository.findAll()){
            departmentList.add(dept);
        }
        return departmentList;
    }

}
