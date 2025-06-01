package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Medicine;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategory;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategoryAssignment;
import ru.ziplla.mashkov_senya_maks.repository.MedicineCategoryAssignmentRepository;
import ru.ziplla.mashkov_senya_maks.repository.MedicineCategoryRepository;
import ru.ziplla.mashkov_senya_maks.repository.MedicineRepository;

import java.util.List;

@Service
public class MedicineCategoryAssignmentService {

    private final MedicineCategoryAssignmentRepository assignmentRepository;
    private final MedicineRepository medicineRepository;
    private final MedicineCategoryRepository categoryRepository;

    public MedicineCategoryAssignmentService(MedicineCategoryAssignmentRepository assignmentRepository,
                                             MedicineRepository medicineRepository,
                                             MedicineCategoryRepository categoryRepository) {
        this.assignmentRepository = assignmentRepository;
        this.medicineRepository = medicineRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<MedicineCategoryAssignment> getAll() {
        return assignmentRepository.findAll();
    }

    public MedicineCategoryAssignment assign(Long medicineId, Long categoryId) {
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new RuntimeException("Лекарство не найдено"));
        MedicineCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));

        MedicineCategoryAssignment assignment = new MedicineCategoryAssignment();
        assignment.setMedicine(medicine);
        assignment.setCategory(category);

        return assignmentRepository.save(assignment);
    }

    public void delete(Long medicineId, Long categoryId) {
        MedicineCategoryAssignment assignment = new MedicineCategoryAssignment();
        Medicine medicine = new Medicine();
        medicine.setMedicineId(medicineId);
        MedicineCategory category = new MedicineCategory();
        category.setCategoryId(categoryId);

        assignment.setMedicine(medicine);
        assignment.setCategory(category);

        assignmentRepository.delete(assignment);
    }
}
