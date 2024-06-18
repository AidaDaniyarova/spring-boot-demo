package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class RolesModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "SALARY")
    private String salary;

    public RolesModel(String roleName, String salary) {
        this.roleName = roleName;
        this.salary = salary;
    }
}
