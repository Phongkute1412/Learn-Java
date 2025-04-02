package backend.backend.service;

import org.springframework.data.domain.Page;

import backend.backend.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    Page<DepartmentDto> getAllDepartments(int pageNo, int pageSize, String sortBy, String sortDir);

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);

}
