package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.ComponentSupply;
import ru.ziplla.mashkov_senya_maks.service.ComponentSupplyService;

import java.util.List;

@RestController
@RequestMapping("/api/component-supplies")
public class ComponentSupplyController {

    private final ComponentSupplyService service;

    public ComponentSupplyController(ComponentSupplyService service) {
        this.service = service;
    }

    @GetMapping
    public List<ComponentSupply> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ComponentSupply getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ComponentSupply create(@RequestParam Long supplierId,
                                  @RequestParam Long componentId,
                                  @RequestBody ComponentSupply supply) {
        return service.create(supplierId, componentId, supply);
    }

    @PutMapping("/{id}")
    public ComponentSupply update(@PathVariable Long id, @RequestBody ComponentSupply supply) {
        return service.update(id, supply);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
