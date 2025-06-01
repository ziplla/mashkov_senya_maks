package ru.ziplla.mashkov_senya_maks.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class PrescriptionComponentId implements Serializable {

    private Long prescription;
    private Long component;

    public PrescriptionComponentId(Long prescription, Long component) {
        this.prescription = prescription;
        this.component = component;
    }

    public Long getPrescription() {
        return prescription;
    }

    public void setPrescription(Long prescription) {
        this.prescription = prescription;
    }

    public Long getComponent() {
        return component;
    }

    public void setComponent(Long component) {
        this.component = component;
    }
}
