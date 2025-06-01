package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.Component;
import ru.ziplla.mashkov_senya_maks.service.ComponentService;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public List<Component> getAll() {
        return componentService.getAll();
    }

    @GetMapping("/{id}")
    public Component getById(@PathVariable Long id) {
        return componentService.getById(id);
    }

    @PostMapping
    public Component create(@RequestBody Component component) {
        return componentService.create(component);
    }

    @PutMapping("/{id}")
    public Component update(@PathVariable Long id, @RequestBody Component component) {
        return componentService.update(id, component);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        componentService.delete(id);
    }
}
