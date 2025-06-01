package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Medicine;
import ru.ziplla.mashkov_senya_maks.entity.Order;
import ru.ziplla.mashkov_senya_maks.entity.Prescription;
import ru.ziplla.mashkov_senya_maks.repository.MedicineRepository;
import ru.ziplla.mashkov_senya_maks.repository.OrderRepository;
import ru.ziplla.mashkov_senya_maks.repository.PrescriptionRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MedicineRepository medicineRepository;
    private final PrescriptionRepository prescriptionRepository;

    public OrderService(OrderRepository orderRepository,
                        MedicineRepository medicineRepository,
                        PrescriptionRepository prescriptionRepository) {
        this.orderRepository = orderRepository;
        this.medicineRepository = medicineRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ не найден"));
    }

    public Order create(Order order) {
        Medicine medicine = medicineRepository.findById(order.getMedicine().getMedicineId())
                .orElseThrow(() -> new RuntimeException("Лекарство не найдено"));

        order.setMedicine(medicine);

        if (order.getPrescription() != null) {
            Long prescId = order.getPrescription().getPrescriptionId();
            Prescription prescription = prescriptionRepository.findById(prescId)
                    .orElseThrow(() -> new RuntimeException("Рецепт не найден"));
            order.setPrescription(prescription);
        }

        return orderRepository.save(order);
    }

    public Order update(Long id, Order updated) {
        Order existing = getById(id);

        Medicine medicine = medicineRepository.findById(updated.getMedicine().getMedicineId())
                .orElseThrow(() -> new RuntimeException("Лекарство не найдено"));

        existing.setMedicine(medicine);
        existing.setOrderDate(updated.getOrderDate());
        existing.setStatus(updated.getStatus());

        if (updated.getPrescription() != null) {
            Long prescId = updated.getPrescription().getPrescriptionId();
            Prescription prescription = prescriptionRepository.findById(prescId)
                    .orElseThrow(() -> new RuntimeException("Рецепт не найден"));
            existing.setPrescription(prescription);
        } else {
            existing.setPrescription(null);
        }

        return orderRepository.save(existing);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
