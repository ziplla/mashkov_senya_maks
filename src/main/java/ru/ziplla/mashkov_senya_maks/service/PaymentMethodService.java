package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.PaymentMethod;
import ru.ziplla.mashkov_senya_maks.repository.PaymentMethodRepository;

import java.util.List;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository repository;

    public PaymentMethodService(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public List<PaymentMethod> getAll() {
        return repository.findAll();
    }

    public PaymentMethod getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Метод оплаты не найден"));
    }

    public PaymentMethod create(PaymentMethod method) {
        return repository.save(method);
    }

    public PaymentMethod update(Long id, PaymentMethod updated) {
        PaymentMethod existing = getById(id);
        existing.setName(updated.getName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
