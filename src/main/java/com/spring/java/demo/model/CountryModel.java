package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY")
public class CountryModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    public CountryModel(String countryName) {
        this.countryName = countryName;
    }
}
