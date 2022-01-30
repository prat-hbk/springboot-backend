package com.prateek.springbootbackend.service.impl;

import com.prateek.springbootbackend.exception.ResourceNotFoundException;
import com.prateek.springbootbackend.model.Employee;
import com.prateek.springbootbackend.repository.EmployeeRepository;
import com.prateek.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        /*Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee", "ID", id);
        }*/

        return employeeRepository.findById(id).orElseThrow(() ->
                                                    new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // whether the employee with given id exists or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
                                                      new ResourceNotFoundException("Employee", "ID", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // Save the existing employee in the database
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }


}
