package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
