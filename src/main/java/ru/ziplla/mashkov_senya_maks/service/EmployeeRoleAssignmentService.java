package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Employee;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRole;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRoleAssignment;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRoleAssignmentId;
import ru.ziplla.mashkov_senya_maks.repository.EmployeeRepository;
import ru.ziplla.mashkov_senya_maks.repository.EmployeeRoleAssignmentRepository;
import ru.ziplla.mashkov_senya_maks.repository.EmployeeRoleRepository;

import java.util.List;

@Service
public class EmployeeRoleAssignmentService {

    private final EmployeeRoleAssignmentRepository repository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeRoleRepository roleRepository;

    public EmployeeRoleAssignmentService(EmployeeRoleAssignmentRepository repository,
                                         EmployeeRepository employeeRepository,
                                         EmployeeRoleRepository roleRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public List<EmployeeRoleAssignment> getAll() {
        return repository.findAll();
    }

    public EmployeeRoleAssignment getById(Long employeeId, Long roleId) {
        return repository.findById(new EmployeeRoleAssignmentId(employeeId, roleId))
                .orElseThrow(() -> new RuntimeException("Назначение не найдено"));
    }

    public EmployeeRoleAssignment create(Long employeeId, Long roleId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));
        EmployeeRole role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Роль не найдена"));

        EmployeeRoleAssignment assignment = new EmployeeRoleAssignment();
        assignment.setEmployee(employee);
        assignment.setRole(role);

        return repository.save(assignment);
    }

    public void delete(Long employeeId, Long roleId) {
        repository.deleteById(new EmployeeRoleAssignmentId(employeeId, roleId));
    }
}
