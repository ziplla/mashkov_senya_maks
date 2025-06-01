package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.AuditLog;
import ru.ziplla.mashkov_senya_maks.service.AuditLogService;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(AuditLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuditLog> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AuditLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AuditLog create(@RequestBody AuditLog auditLog) {
        return service.create(auditLog);
    }

    @PutMapping("/{id}")
    public AuditLog update(@PathVariable Long id, @RequestBody AuditLog auditLog) {
        return service.update(id, auditLog);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
