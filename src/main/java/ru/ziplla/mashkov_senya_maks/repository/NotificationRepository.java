package ru.ziplla.mashkov_senya_maks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.mashkov_senya_maks.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
