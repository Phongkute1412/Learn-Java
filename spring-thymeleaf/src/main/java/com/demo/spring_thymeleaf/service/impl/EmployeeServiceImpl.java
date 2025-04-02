package com.demo.spring_thymeleaf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.spring_thymeleaf.dto.EmployeeDto;
import com.demo.spring_thymeleaf.entity.Employee;
import com.demo.spring_thymeleaf.entity.Role;
import com.demo.spring_thymeleaf.mapper.EmployeeMapper;
import com.demo.spring_thymeleaf.repository.EmployeeRepository;
import com.demo.spring_thymeleaf.repository.RoleRepository;
import com.demo.spring_thymeleaf.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<EmployeeDto> getAllEmployees(String keyword, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> employees = employeeRepository.findAll(pageable);

        if (keyword == null) {
            employees = employeeRepository.findAll(pageable);
        } else {
            employees = employeeRepository.findByAccountContainingIgnoreCase(keyword, pageable);
        }

        return employees.map(EmployeeMapper::mapToDto);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Role role = roleRepository.findByRoleName(employeeDto.getRole())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));

        Employee employee = EmployeeMapper.mapToEntity(employeeDto);
        employee.setRole(role);

        employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));

        Role role = roleRepository.findByRoleName(employeeDto.getRole())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAccount(employeeDto.getAccount());
        employee.setRole(role);
        employee.setProject(employeeDto.getProject());

        employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employeeRepository.delete(employee);
    }

}
