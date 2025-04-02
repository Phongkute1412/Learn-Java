package backend.backend.mapper;

import backend.backend.dto.EmployeeDto;
import backend.backend.entity.Department;
import backend.backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getDepartmentName(),
                employee.getProject());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        Department department = new Department();
        department.setDepartmentName(employeeDto.getDepartmentName());

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                department,
                employeeDto.getProject());
    }
}
