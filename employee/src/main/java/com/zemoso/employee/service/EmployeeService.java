package com.zemoso.employee.service;

import com.zemoso.employee.model.Employee;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployee(Long id);

    public void addEmployee(Employee employee);

    public void updateEmployee(Long id, Employee employee);

    public void deleteEmployee(Long id);
}
