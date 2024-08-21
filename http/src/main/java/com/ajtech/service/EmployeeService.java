package com.ajtech.service;
import com.ajtech.entity.Employee;
import com.ajtech.exception.EmployeeBadRequestException;
import com.ajtech.exception.EmployeeNotFoundException;
import com.ajtech.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null || employee.getCity() == null) {
            throw new EmployeeBadRequestException("Employee details are incomplete");
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        if (employeeDetails.getFirstName() == null || employeeDetails.getLastName() == null || employeeDetails.getCity() == null) {
            throw new EmployeeBadRequestException("Employee details are incomplete");
        }
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setCity(employeeDetails.getCity());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
