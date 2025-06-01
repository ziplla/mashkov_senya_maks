package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Supplier;
import ru.ziplla.mashkov_senya_maks.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> getAll() {
        return repository.findAll();
    }

    public Supplier getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Поставщик не найден"));
    }

    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    public Supplier update(Long id, Supplier updated) {
        Supplier existing = getById(id);
        existing.setName(updated.getName());
        existing.setContactInfo(updated.getContactInfo());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
