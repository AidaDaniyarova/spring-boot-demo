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
    private Long id;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EMPLOYEE_NUMBER")
    private int employeeNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private CompanyModel company;

    public DepartmentModel(String departmentName, String description, CompanyModel company) {
        this.departmentName = departmentName;
        this.description = description;
        this.company = company;
    }
}
