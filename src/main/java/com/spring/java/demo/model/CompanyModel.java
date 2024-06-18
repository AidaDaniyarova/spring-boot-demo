package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMPANY")
public class CompanyModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "DESCRIPTION")
    private String description;

    public CompanyModel(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }
}
