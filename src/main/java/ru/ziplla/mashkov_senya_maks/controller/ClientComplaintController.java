package ru.ziplla.mashkov_senya_maks.controller;

import org.springframework.web.bind.annotation.*;
import ru.ziplla.mashkov_senya_maks.entity.ClientComplaint;
import ru.ziplla.mashkov_senya_maks.service.ClientComplaintService;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ClientComplaintController {

    private final ClientComplaintService service;

    public ClientComplaintController(ClientComplaintService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClientComplaint> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClientComplaint getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ClientComplaint create(@RequestParam Long clientId, @RequestBody ClientComplaint complaint) {
        return service.create(clientId, complaint);
    }

    @PutMapping("/{id}")
    public ClientComplaint update(@PathVariable Long id, @RequestBody ClientComplaint complaint) {
        return service.update(id, complaint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
