package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.MedicineCategory;
import ru.ziplla.mashkov_senya_maks.service.MedicineCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/medicine-categories")
public class MedicineCategoryController {

    private final MedicineCategoryService service;

    public MedicineCategoryController(MedicineCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<MedicineCategory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicineCategory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public MedicineCategory create(@RequestBody MedicineCategory category) {
        return service.create(category);
    }

    @PutMapping("/{id}")
    public MedicineCategory update(@PathVariable Long id, @RequestBody MedicineCategory category) {
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
