package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.PrescriptionComponent;
import ru.ziplla.mashkov_senya_maks.entity.PrescriptionComponentId;

public interface PrescriptionComponentRepository extends JpaRepository<PrescriptionComponent, PrescriptionComponentId> {
}
