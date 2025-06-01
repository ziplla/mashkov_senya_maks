package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Client;
import ru.ziplla.mashkov_senya_maks.entity.Prescription;
import ru.ziplla.mashkov_senya_maks.repository.ClientRepository;
import ru.ziplla.mashkov_senya_maks.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final ClientRepository clientRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, ClientRepository clientRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.clientRepository = clientRepository;
    }

    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription getById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Рецепт не найден"));
    }

    public Prescription create(Prescription prescription) {
        Long clientId = prescription.getClient().getClientId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));
        prescription.setClient(client);
        return prescriptionRepository.save(prescription);
    }

    public Prescription update(Long id, Prescription updated) {
        Prescription existing = getById(id);
        existing.setComponents(updated.getComponents());
        existing.setOrderDate(updated.getOrderDate());
        existing.setStatus(updated.getStatus());

        Long clientId = updated.getClient().getClientId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));
        existing.setClient(client);

        return prescriptionRepository.save(existing);
    }

    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
