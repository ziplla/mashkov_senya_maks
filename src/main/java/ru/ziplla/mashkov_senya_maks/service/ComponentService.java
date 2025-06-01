package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Component;
import ru.ziplla.mashkov_senya_maks.repository.ComponentRepository;

import java.util.List;

@Service
public class ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public List<Component> getAll() {
        return componentRepository.findAll();
    }

    public Component getById(Long id) {
        return componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Компонент не найден"));
    }

    public Component create(Component component) {
        return componentRepository.save(component);
    }

    public Component update(Long id, Component updated) {
        Component existing = getById(id);
        existing.setName(updated.getName());
        existing.setQuantity(updated.getQuantity());
        existing.setCriticalLevel(updated.getCriticalLevel());
        return componentRepository.save(existing);
    }

    public void delete(Long id) {
        componentRepository.deleteById(id);
    }
}
