package com.azkamis.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azkamis.springbootdemo.mapper.MapStructMapper;
import com.azkamis.springbootdemo.model.ApiResponse;
import com.azkamis.springbootdemo.model.Employee;
import com.azkamis.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private final MapStructMapper mapstructMapper;
	
	private final EmployeeService empService;
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
    public EmployeeController(
    		MapStructMapper mapstructMapper,
    		EmployeeService empService){
        this.mapstructMapper = mapstructMapper;
		this.empService = empService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.CREATED.value(),
	                "Employee created successfully.",
	                empService.createEmployee(emp)),
                HttpStatus.CREATED);
    }
    
    @GetMapping("/employees")
    public ResponseEntity<Object> readEmployees() {
    	return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(),
	                "Employee list fetched successfully.",
	                mapstructMapper.employeeListToEmployeeGetDtoList(empService.getEmployees())),
                HttpStatus.OK);
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<Object> readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(),
	                "Employee deleted successfully.",
	                empService.updateEmployee(id, empDetails)),
                HttpStatus.OK);
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Object> deleteEmployees(@PathVariable(value = "empId") Long id) {
    	empService.deleteEmployee(id);
    	logger.info("info!");
        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(),
	                "Employee deleted successfully."),
                HttpStatus.OK);
    }
}
