package com.demo.spring_thymeleaf.mapper;

import com.demo.spring_thymeleaf.dto.EmployeeDto;
import com.demo.spring_thymeleaf.entity.Employee;
import com.demo.spring_thymeleaf.entity.Role;

public class EmployeeMapper {

    public static EmployeeDto mapToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAccount(),
                employee.getRole().getRoleName(),
                employee.getProject());
    }

    public static Employee mapToEntity(EmployeeDto employeeDto) {

        Role role = new Role();
        role.setRoleName(employeeDto.getRole());

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAccount(),
                role,
                employeeDto.getProject());
    }

}
