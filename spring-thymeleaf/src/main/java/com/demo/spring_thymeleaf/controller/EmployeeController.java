package com.demo.spring_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.demo.spring_thymeleaf.dto.EmployeeDto;
import com.demo.spring_thymeleaf.repository.RoleRepository;
import com.demo.spring_thymeleaf.service.impl.EmployeeServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ems")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public String listEmployees(Model model,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Page<EmployeeDto> employees = employeeService.getAllEmployees(keyword, page, size, sortBy, sortDir);

        if (keyword != null) {
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("employees", employees);
        model.addAttribute("currentPage", employees.getNumber() + 1);
        model.addAttribute("totalItems", employees.getTotalElements());
        model.addAttribute("totalPages", employees.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "employees";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("roles", roleRepository.findAll());
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return "addEmployee"; // Return to the form with error messages
        }

        try {
            employeeService.createEmployee(employeeDto);
            return "redirect:/ems";
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found", e);
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeDto);
        model.addAttribute("roles", roleRepository.findAll());
        return "editEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return "editEmployee";
        }

        try {
            employeeService.updateEmployee(employeeDto);
            return "redirect:/ems";
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee or Role not found", e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, Model model) {
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", e);
        }

        return "redirect:/ems";
    }

    @ExceptionHandler(ResponseStatusException.class)
    public String handleNotFoundException(ResponseStatusException ex, Model model) {
        model.addAttribute("errorMessage", ex.getReason());
        return "error404";
    }

}
