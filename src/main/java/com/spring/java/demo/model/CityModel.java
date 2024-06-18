package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CITY")
public class CityModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CITY_NAME")
    public String cityName;
    @Column(name = "COUNTRY_ID")
    private int countryID;

    public CityModel(String cityName, int countryID) {
        this.cityName = cityName;
        this.countryID = countryID;
    }
}
