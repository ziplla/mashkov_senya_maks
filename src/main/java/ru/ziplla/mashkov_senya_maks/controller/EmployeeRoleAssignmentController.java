package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRoleAssignment;
import ru.ziplla.mashkov_senya_maks.service.EmployeeRoleAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/employee-role-assignments")
public class EmployeeRoleAssignmentController {

    private final EmployeeRoleAssignmentService service;

    public EmployeeRoleAssignmentController(EmployeeRoleAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeRoleAssignment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{employeeId}/{roleId}")
    public EmployeeRoleAssignment getById(@PathVariable Long employeeId, @PathVariable Long roleId) {
        return service.getById(employeeId, roleId);
    }

    @PostMapping
    public EmployeeRoleAssignment create(@RequestParam Long employeeId, @RequestParam Long roleId) {
        return service.create(employeeId, roleId);
    }

    @DeleteMapping("/{employeeId}/{roleId}")
    public void delete(@PathVariable Long employeeId, @PathVariable Long roleId) {
        service.delete(employeeId, roleId);
    }
}
