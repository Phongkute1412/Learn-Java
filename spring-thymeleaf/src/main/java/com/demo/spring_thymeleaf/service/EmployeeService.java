package com.demo.spring_thymeleaf.service;

import org.springframework.data.domain.Page;

import com.demo.spring_thymeleaf.dto.EmployeeDto;

public interface EmployeeService {

    Page<EmployeeDto> getAllEmployees(String keyword, int pageNo, int pageSize, String sortBy, String sortDir);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id);

}
