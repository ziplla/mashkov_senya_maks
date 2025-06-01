package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.*;
import ru.ziplla.mashkov_senya_maks.repository.*;

import java.util.List;

@Service
public class MedicineProductionService {

    private final MedicineProductionRepository productionRepository;
    private final MedicineRepository medicineRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final EmployeeRepository employeeRepository;

    public MedicineProductionService(MedicineProductionRepository productionRepository,
                                     MedicineRepository medicineRepository,
                                     PrescriptionRepository prescriptionRepository,
                                     EmployeeRepository employeeRepository) {
        this.productionRepository = productionRepository;
        this.medicineRepository = medicineRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<MedicineProduction> getAll() {
        return productionRepository.findAll();
    }

    public MedicineProduction getById(Long id) {
        return productionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Производство не найдено"));
    }

    public MedicineProduction create(Long medicineId, Long prescriptionId, Long employeeId, MedicineProduction input) {
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new RuntimeException("Лекарство не найдено"));
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new RuntimeException("Рецепт не найден"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));

        input.setMedicine(medicine);
        input.setPrescription(prescription);
        input.setEmployee(employee);
        return productionRepository.save(input);
    }

    public MedicineProduction update(Long id, MedicineProduction updated) {
        MedicineProduction existing = getById(id);
        existing.setProducedAt(updated.getProducedAt());
        return productionRepository.save(existing);
    }

    public void delete(Long id) {
        productionRepository.deleteById(id);
    }
}
