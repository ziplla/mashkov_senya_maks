package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
