package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategoryAssignment;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategoryAssignmentId;

public interface MedicineCategoryAssignmentRepository extends JpaRepository<MedicineCategoryAssignment, MedicineCategoryAssignmentId> {
}
