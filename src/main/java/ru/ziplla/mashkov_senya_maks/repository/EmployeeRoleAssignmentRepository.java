package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRoleAssignment;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRoleAssignmentId;

public interface EmployeeRoleAssignmentRepository extends JpaRepository<EmployeeRoleAssignment, EmployeeRoleAssignmentId> {
}
