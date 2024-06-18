package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EMPLOYEE_NUMBER")
    private int employeeNumber;
    @Column(name = "COMPANY_ID")
    private int companyId;

    public DepartmentModel(String departmentName, String description, int companyId) {
        this.departmentName = departmentName;
        this.description = description;
        this.companyId = companyId;
    }
}
