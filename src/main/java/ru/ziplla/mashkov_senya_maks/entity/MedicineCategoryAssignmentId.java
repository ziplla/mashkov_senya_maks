package ru.ziplla.mashkov_senya_maks.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MedicineCategoryAssignmentId implements Serializable {
    private Long medicine;
    private Long category;

    public Long getMedicine() {
        return medicine;
    }

    public void setMedicine(Long medicine) {
        this.medicine = medicine;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
