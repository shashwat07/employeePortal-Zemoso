package com.zemoso.department.controller;

import com.zemoso.department.model.Department;
import com.zemoso.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method= RequestMethod.GET, value="/departments")
    @ResponseBody
    public ResponseEntity<Map> getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("departments", departments);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
