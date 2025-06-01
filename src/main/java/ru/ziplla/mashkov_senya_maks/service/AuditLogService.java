package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.AuditLog;
import ru.ziplla.mashkov_senya_maks.repository.AuditLogRepository;

import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public List<AuditLog> getAll() {
        return auditLogRepository.findAll();
    }

    public AuditLog getById(Long id) {
        return auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Лог не найден"));
    }

    public AuditLog create(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    public AuditLog update(Long id, AuditLog updated) {
        AuditLog existing = getById(id);
        existing.setUserType(updated.getUserType());
        existing.setUserId(updated.getUserId());
        existing.setAction(updated.getAction());
        existing.setTimestamp(updated.getTimestamp());
        return auditLogRepository.save(existing);
    }

    public void delete(Long id) {
        auditLogRepository.deleteById(id);
    }
}
