package com.azkamis.springbootdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azkamis.springbootdemo.model.Employee;
import com.azkamis.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
	private final EmployeeService empService;
    
    public EmployeeController(EmployeeService empService){
        this.empService = empService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }
    
    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    @PutMapping("/employees/{empId}")
    public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }
}
