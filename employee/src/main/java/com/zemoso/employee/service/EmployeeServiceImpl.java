package com.zemoso.employee.service;

import com.zemoso.employee.model.Employee;
import com.zemoso.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return (List<Employee>)employeeRepository.findAll();
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findOne(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Long id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.delete(id);
    }
}
