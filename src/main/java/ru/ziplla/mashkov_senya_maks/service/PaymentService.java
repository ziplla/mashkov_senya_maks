package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Order;
import ru.ziplla.mashkov_senya_maks.entity.Payment;
import ru.ziplla.mashkov_senya_maks.entity.PaymentMethod;
import ru.ziplla.mashkov_senya_maks.repository.OrderRepository;
import ru.ziplla.mashkov_senya_maks.repository.PaymentMethodRepository;
import ru.ziplla.mashkov_senya_maks.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          OrderRepository orderRepository,
                          PaymentMethodRepository paymentMethodRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Платёж не найден"));
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment createFromIds(Long orderId, Long methodId, Payment paymentData) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Заказ не найден"));
        PaymentMethod method = paymentMethodRepository.findById(methodId).orElseThrow(() -> new RuntimeException("Метод оплаты не найден"));

        paymentData.setOrder(order);
        paymentData.setMethod(method);
        return paymentRepository.save(paymentData);
    }

    public Payment update(Long id, Payment updated) {
        Payment existing = getById(id);
        existing.setAmount(updated.getAmount());
        existing.setPaymentDate(updated.getPaymentDate());
        return paymentRepository.save(existing);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
