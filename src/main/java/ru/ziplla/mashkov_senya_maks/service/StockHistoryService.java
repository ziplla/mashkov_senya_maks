package ru.ziplla.mashkov_senya_maks.service;

import org.springframework.stereotype.Service;
import ru.ziplla.mashkov_senya_maks.entity.Component;
import ru.ziplla.mashkov_senya_maks.entity.StockHistory;
import ru.ziplla.mashkov_senya_maks.repository.ComponentRepository;
import ru.ziplla.mashkov_senya_maks.repository.StockHistoryRepository;

import java.util.List;

@Service
public class StockHistoryService {

    private final StockHistoryRepository historyRepository;
    private final ComponentRepository componentRepository;

    public StockHistoryService(StockHistoryRepository historyRepository, ComponentRepository componentRepository) {
        this.historyRepository = historyRepository;
        this.componentRepository = componentRepository;
    }

    public List<StockHistory> getAll() {
        return historyRepository.findAll();
    }

    public StockHistory getById(Long id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("История не найдена"));
    }

    public StockHistory create(Long componentId, StockHistory history) {
        Component component = componentRepository.findById(componentId)
                .orElseThrow(() -> new RuntimeException("Компонент не найден"));
        history.setComponent(component);
        return historyRepository.save(history);
    }

    public StockHistory update(Long id, StockHistory updated) {
        StockHistory existing = getById(id);
        existing.setChange(updated.getChange());
        existing.setChangeDate(updated.getChangeDate());
        existing.setReason(updated.getReason());
        return historyRepository.save(existing);
    }

    public void delete(Long id) {
        historyRepository.deleteById(id);
    }
}
