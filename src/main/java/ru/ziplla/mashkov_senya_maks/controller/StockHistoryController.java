package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.StockHistory;
import ru.ziplla.mashkov_senya_maks.service.StockHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/stock-history")
public class StockHistoryController {

    private final StockHistoryService service;

    public StockHistoryController(StockHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<StockHistory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StockHistory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public StockHistory create(@RequestParam Long componentId,
                               @RequestBody StockHistory history) {
        return service.create(componentId, history);
    }

    @PutMapping("/{id}")
    public StockHistory update(@PathVariable Long id,
                               @RequestBody StockHistory updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
