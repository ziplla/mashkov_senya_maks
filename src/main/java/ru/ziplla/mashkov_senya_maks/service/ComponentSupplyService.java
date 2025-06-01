package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Component;
import ru.ziplla.mashkov_senya_maks.entity.ComponentSupply;
import ru.ziplla.mashkov_senya_maks.entity.Supplier;
import ru.ziplla.mashkov_senya_maks.repository.ComponentRepository;
import ru.ziplla.mashkov_senya_maks.repository.ComponentSupplyRepository;
import ru.ziplla.mashkov_senya_maks.repository.SupplierRepository;

import java.util.List;

@Service
public class ComponentSupplyService {

    private final ComponentSupplyRepository repository;
    private final SupplierRepository supplierRepository;
    private final ComponentRepository componentRepository;

    public ComponentSupplyService(ComponentSupplyRepository repository,
                                  SupplierRepository supplierRepository,
                                  ComponentRepository componentRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
        this.componentRepository = componentRepository;
    }

    public List<ComponentSupply> getAll() {
        return repository.findAll();
    }

    public ComponentSupply getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Поставка не найдена"));
    }

    public ComponentSupply create(Long supplierId, Long componentId, ComponentSupply supply) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Поставщик не найден"));
        Component component = componentRepository.findById(componentId)
                .orElseThrow(() -> new RuntimeException("Компонент не найден"));

        supply.setSupplier(supplier);
        supply.setComponent(component);

        return repository.save(supply);
    }

    public ComponentSupply update(Long id, ComponentSupply updatedSupply) {
        ComponentSupply existing = getById(id);
        existing.setQuantity(updatedSupply.getQuantity());
        existing.setSupplyDate(updatedSupply.getSupplyDate());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
