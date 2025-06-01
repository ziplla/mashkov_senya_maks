package ru.ziplla.mashkov_senya_maks.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeRoleAssignmentId implements Serializable {
    private Long employee;
    private Long role;

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public EmployeeRoleAssignmentId(Long employee, Long role) {
        this.employee = employee;
        this.role = role;
    }
}
