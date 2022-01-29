package com.prateek.springbootbackend.service;

import com.prateek.springbootbackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
