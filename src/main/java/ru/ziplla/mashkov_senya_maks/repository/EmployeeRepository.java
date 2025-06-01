package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
