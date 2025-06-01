package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.PrescriptionComponent;
import ru.ziplla.mashkov_senya_maks.service.PrescriptionComponentService;

import java.util.List;

@RestController
@RequestMapping("/api/prescription-components")
public class PrescriptionComponentController {

    private final PrescriptionComponentService service;

    public PrescriptionComponentController(PrescriptionComponentService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrescriptionComponent> getAll() {
        return service.getAll();
    }

    @GetMapping("/{prescriptionId}/{componentId}")
    public PrescriptionComponent getById(@PathVariable Long prescriptionId, @PathVariable Long componentId) {
        return service.getById(prescriptionId, componentId);
    }

    @PostMapping
    public PrescriptionComponent create(@RequestParam Long prescriptionId,
                                        @RequestParam Long componentId,
                                        @RequestParam Integer amount) {
        return service.create(prescriptionId, componentId, amount);
    }

    @PutMapping("/{prescriptionId}/{componentId}")
    public PrescriptionComponent update(@PathVariable Long prescriptionId,
                                        @PathVariable Long componentId,
                                        @RequestParam Integer amount) {
        return service.update(prescriptionId, componentId, amount);
    }

    @DeleteMapping("/{prescriptionId}/{componentId}")
    public void delete(@PathVariable Long prescriptionId, @PathVariable Long componentId) {
        service.delete(prescriptionId, componentId);
    }
}
