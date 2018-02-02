package com.zemoso.employee.service;

import com.zemoso.employee.model.Employee;
import com.zemoso.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(String id){
        return employeeRepository.findOne(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(String id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id){
        employeeRepository.delete(id);
    }
}
