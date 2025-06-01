package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategoryAssignment;
import ru.ziplla.mashkov_senya_maks.service.MedicineCategoryAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/medicine-category-assignments")
public class MedicineCategoryAssignmentController {

    private final MedicineCategoryAssignmentService service;

    public MedicineCategoryAssignmentController(MedicineCategoryAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<MedicineCategoryAssignment> getAll() {
        return service.getAll();
    }

    @PostMapping
    public MedicineCategoryAssignment assign(@RequestParam Long medicineId, @RequestParam Long categoryId) {
        return service.assign(medicineId, categoryId);
    }

    @DeleteMapping
    public void delete(@RequestParam Long medicineId, @RequestParam Long categoryId) {
        service.delete(medicineId, categoryId);
    }
}
