package ru.ziplla.mashkov_senya_maks.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prescription_components")
@IdClass(PrescriptionComponentId.class)
public class PrescriptionComponent {

    @Id
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component component;

    private Integer amount;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
