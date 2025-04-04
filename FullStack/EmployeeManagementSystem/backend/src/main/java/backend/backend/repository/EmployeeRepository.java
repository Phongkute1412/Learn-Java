package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
