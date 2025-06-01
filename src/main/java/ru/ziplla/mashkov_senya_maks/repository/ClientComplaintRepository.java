package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.ClientComplaint;

public interface ClientComplaintRepository extends JpaRepository<ClientComplaint, Long> {
}
