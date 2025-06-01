package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.PaymentMethod;
import ru.ziplla.mashkov_senya_maks.service.PaymentMethodService;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService service;

    public PaymentMethodController(PaymentMethodService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaymentMethod> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PaymentMethod getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PaymentMethod create(@RequestBody PaymentMethod method) {
        return service.create(method);
    }

    @PutMapping("/{id}")
    public PaymentMethod update(@PathVariable Long id, @RequestBody PaymentMethod method) {
        return service.update(id, method);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
