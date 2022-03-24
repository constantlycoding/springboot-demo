package com.azkamis.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azkamis.springbootdemo.model.Employee;
import com.azkamis.springbootdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository empRepository;
    
    public EmployeeService(EmployeeRepository empRepository){
        this.empRepository = empRepository;
    }
    
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }

    public void deleteEmployee(Long empId) {
        empRepository.deleteById(empId);
    }
    
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = empRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());
        
        return empRepository.save(emp);                                
    }
}
