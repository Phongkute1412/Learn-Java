package com.demo.spring_thymeleaf.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 128, message = "First name must be between 2 and 128 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 256, message = "Last name must be between 2 and 256 characters")
    private String lastName;

    @NotEmpty(message = "Account cannot be empty")
    private String account;

    @NotEmpty(message = "Role cannot be empty")
    private String role;

    private String project;

}
