package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRole;
import ru.ziplla.mashkov_senya_maks.service.EmployeeRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/employee-roles")
public class EmployeeRoleController {

    private final EmployeeRoleService service;

    public EmployeeRoleController(EmployeeRoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeRole> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeRole getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public EmployeeRole create(@RequestBody EmployeeRole role) {
        return service.create(role);
    }

    @PutMapping("/{id}")
    public EmployeeRole update(@PathVariable Long id, @RequestBody EmployeeRole role) {
        return service.update(id, role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
