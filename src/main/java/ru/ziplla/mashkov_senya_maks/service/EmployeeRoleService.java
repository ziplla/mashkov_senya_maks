package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.EmployeeRole;
import ru.ziplla.mashkov_senya_maks.repository.EmployeeRoleRepository;

import java.util.List;

@Service
public class EmployeeRoleService {

    private final EmployeeRoleRepository repository;

    public EmployeeRoleService(EmployeeRoleRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeRole> getAll() {
        return repository.findAll();
    }

    public EmployeeRole getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Роль не найдена"));
    }

    public EmployeeRole create(EmployeeRole role) {
        return repository.save(role);
    }

    public EmployeeRole update(Long id, EmployeeRole updated) {
        EmployeeRole existing = getById(id);
        existing.setName(updated.getName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
