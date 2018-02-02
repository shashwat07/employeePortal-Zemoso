package com.zemoso.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemoso.employee.model.Employee;
import com.zemoso.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method=RequestMethod.GET, value="/employees")
    @ResponseBody
    public ResponseEntity<Map> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("employees", employees);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/newEmployees")
    public void addEmployee(@RequestBody Map<String, Object> data){
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        Employee employee = mapper.convertValue(data.get("newEmployee"), Employee.class);
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
    public void updateEmployee(@PathVariable String id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }
}
