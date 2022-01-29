package com.prateek.springbootbackend.controller;

import com.prateek.springbootbackend.model.Employee;
import com.prateek.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employees REST API
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
}
