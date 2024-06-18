package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFILE")
public class ProfileModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "ADDRESS_ID")
    private int addressId;
    @Column(name = "ROLE_ID")
    private int roleId;
    @Column(name = "ASSIGNMENT_ID")
    private int assignmentId;
    @Column(name = "DEPARTMENT_ID")
    private int departmentId;

    public ProfileModel(int userId, int addressId, int roleId, int assignmentId, int departmentId) {
        this.userId = userId;
        this.addressId = addressId;
        this.roleId = roleId;
        this.assignmentId = assignmentId;
        this.departmentId = departmentId;
    }
}
