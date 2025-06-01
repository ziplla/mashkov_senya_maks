package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Medicine;
import ru.ziplla.mashkov_senya_maks.repository.MedicineRepository;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    public Medicine getById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Лекарство не найдено"));
    }

    public Medicine create(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine update(Long id, Medicine updated) {
        Medicine existing = getById(id);
        existing.setName(updated.getName());
        existing.setType(updated.getType());
        existing.setUsage(updated.getUsage());
        existing.setPrice(updated.getPrice());
        existing.setStockQuantity(updated.getStockQuantity());
        return medicineRepository.save(existing);
    }

    public void delete(Long id) {
        medicineRepository.deleteById(id);
    }
}
