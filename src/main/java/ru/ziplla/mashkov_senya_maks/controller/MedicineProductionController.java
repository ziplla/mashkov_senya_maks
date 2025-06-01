package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.MedicineProduction;
import ru.ziplla.mashkov_senya_maks.service.MedicineProductionService;

import java.util.List;

@RestController
@RequestMapping("/api/productions")
public class MedicineProductionController {

    private final MedicineProductionService service;

    public MedicineProductionController(MedicineProductionService service) {
        this.service = service;
    }

    @GetMapping
    public List<MedicineProduction> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicineProduction getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public MedicineProduction create(@RequestParam Long medicineId,
                                     @RequestParam Long prescriptionId,
                                     @RequestParam Long employeeId,
                                     @RequestBody MedicineProduction input) {
        return service.create(medicineId, prescriptionId, employeeId, input);
    }

    @PutMapping("/{id}")
    public MedicineProduction update(@PathVariable Long id,
                                     @RequestBody MedicineProduction input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
