package com.zemoso.employee.service;

import com.zemoso.employee.model.Employee;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployee(String id);

    public void addEmployee(Employee employee);

    public void updateEmployee(String id, Employee employee);

    public void deleteEmployee(String id);
}
