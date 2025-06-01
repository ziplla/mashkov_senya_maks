package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Component;
import ru.ziplla.mashkov_senya_maks.entity.Prescription;
import ru.ziplla.mashkov_senya_maks.entity.PrescriptionComponent;
import ru.ziplla.mashkov_senya_maks.entity.PrescriptionComponentId;
import ru.ziplla.mashkov_senya_maks.repository.ComponentRepository;
import ru.ziplla.mashkov_senya_maks.repository.PrescriptionComponentRepository;
import ru.ziplla.mashkov_senya_maks.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionComponentService {

    private final PrescriptionComponentRepository repository;
    private final PrescriptionRepository prescriptionRepository;
    private final ComponentRepository componentRepository;

    public PrescriptionComponentService(PrescriptionComponentRepository repository,
                                        PrescriptionRepository prescriptionRepository,
                                        ComponentRepository componentRepository) {
        this.repository = repository;
        this.prescriptionRepository = prescriptionRepository;
        this.componentRepository = componentRepository;
    }

    public List<PrescriptionComponent> getAll() {
        return repository.findAll();
    }

    public PrescriptionComponent getById(Long prescriptionId, Long componentId) {
        return repository.findById(new PrescriptionComponentId(prescriptionId, componentId))
                .orElseThrow(() -> new RuntimeException("Запись не найдена"));
    }

    public PrescriptionComponent create(Long prescriptionId, Long componentId, Integer amount) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new RuntimeException("Рецепт не найден"));
        Component component = componentRepository.findById(componentId)
                .orElseThrow(() -> new RuntimeException("Компонент не найден"));

        PrescriptionComponent pc = new PrescriptionComponent();
        pc.setPrescription(prescription);
        pc.setComponent(component);
        pc.setAmount(amount);

        return repository.save(pc);
    }

    public PrescriptionComponent update(Long prescriptionId, Long componentId, Integer amount) {
        PrescriptionComponent pc = getById(prescriptionId, componentId);
        pc.setAmount(amount);
        return repository.save(pc);
    }

    public void delete(Long prescriptionId, Long componentId) {
        repository.deleteById(new PrescriptionComponentId(prescriptionId, componentId));
    }
}
