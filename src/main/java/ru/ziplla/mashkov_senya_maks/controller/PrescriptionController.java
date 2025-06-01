package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.Prescription;
import ru.ziplla.mashkov_senya_maks.service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public List<Prescription> getAll() {
        return prescriptionService.getAll();
    }

    @GetMapping("/{id}")
    public Prescription getById(@PathVariable Long id) {
        return prescriptionService.getById(id);
    }

    @PostMapping
    public Prescription create(@RequestBody Prescription prescription) {
        return prescriptionService.create(prescription);
    }

    @PutMapping("/{id}")
    public Prescription update(@PathVariable Long id, @RequestBody Prescription prescription) {
        return prescriptionService.update(id, prescription);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        prescriptionService.delete(id);
    }
}
