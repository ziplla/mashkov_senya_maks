package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Client;
import ru.ziplla.mashkov_senya_maks.entity.ClientComplaint;
import ru.ziplla.mashkov_senya_maks.repository.ClientComplaintRepository;
import ru.ziplla.mashkov_senya_maks.repository.ClientRepository;

import java.util.List;

@Service
public class ClientComplaintService {

    private final ClientComplaintRepository complaintRepository;
    private final ClientRepository clientRepository;

    public ClientComplaintService(ClientComplaintRepository complaintRepository,
                                  ClientRepository clientRepository) {
        this.complaintRepository = complaintRepository;
        this.clientRepository = clientRepository;
    }

    public List<ClientComplaint> getAll() {
        return complaintRepository.findAll();
    }

    public ClientComplaint getById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Жалоба не найдена"));
    }

    public ClientComplaint create(Long clientId, ClientComplaint complaint) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));
        complaint.setClient(client);
        return complaintRepository.save(complaint);
    }

    public ClientComplaint update(Long id, ClientComplaint updated) {
        ClientComplaint existing = getById(id);
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        return complaintRepository.save(existing);
    }

    public void delete(Long id) {
        complaintRepository.deleteById(id);
    }
}
