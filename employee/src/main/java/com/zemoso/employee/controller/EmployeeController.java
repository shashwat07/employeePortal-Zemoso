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

    public static final String EMPLOYEE = "employee";
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
    public ResponseEntity<Map> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put(EMPLOYEE, employee);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, value="/employees")
    public void addEmployee(@RequestBody Map<String, Object> data){
        final ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.convertValue(data.get(EMPLOYEE), Employee.class);
        if(employee.getImage().equals("")){
            employee.setImage("http://trade-mgmt.com/wp-content/uploads/2016/08/facebook-default-no-profile-pic.jpg");
        }
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Map<String, Object> data){
        final ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.convertValue(data.get(EMPLOYEE), Employee.class);
        employee.setId(id);
        if(employee.getImage().equals("")){
            employee.setImage("http://trade-mgmt.com/wp-content/uploads/2016/08/facebook-default-no-profile-pic.jpg");
        }
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
