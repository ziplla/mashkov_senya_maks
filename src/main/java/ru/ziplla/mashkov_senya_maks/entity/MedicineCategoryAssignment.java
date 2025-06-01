package ru.ziplla.mashkov_senya_maks.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicine_category_assignments")
@IdClass(MedicineCategoryAssignmentId.class)
public class MedicineCategoryAssignment {

    @Id
    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private MedicineCategory category;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public MedicineCategory getCategory() {
        return category;
    }

    public void setCategory(MedicineCategory category) {
        this.category = category;
    }
}
