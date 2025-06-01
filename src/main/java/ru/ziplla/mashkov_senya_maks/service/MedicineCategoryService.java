package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategory;
import ru.ziplla.mashkov_senya_maks.repository.MedicineCategoryRepository;

import java.util.List;

@Service
public class MedicineCategoryService {

    private final MedicineCategoryRepository repository;

    public MedicineCategoryService(MedicineCategoryRepository repository) {
        this.repository = repository;
    }

    public List<MedicineCategory> getAll() {
        return repository.findAll();
    }

    public MedicineCategory getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Категория не найдена"));
    }

    public MedicineCategory create(MedicineCategory category) {
        return repository.save(category);
    }

    public MedicineCategory update(Long id, MedicineCategory updated) {
        MedicineCategory existing = getById(id);
        existing.setName(updated.getName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
