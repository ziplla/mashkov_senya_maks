package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ziplla.mashkov_senya_maks.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

