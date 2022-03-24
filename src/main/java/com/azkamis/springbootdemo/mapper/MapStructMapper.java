package com.azkamis.springbootdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.azkamis.springbootdemo.dto.EmployeeGetDto;
import com.azkamis.springbootdemo.model.Employee;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
	EmployeeGetDto employeeToEmployeeGetDto(Employee employee);
	List<EmployeeGetDto> employeeListToEmployeeGetDtoList(List<Employee> employees);
}
