package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ADDRESS_NAME")
    private String addressName;
    @Column(name = "COUNTRY_ID")
    private int countryId;
    @Column(name = "CITY_ID")
    private int cityId;

    public AddressModel(String addressName, int countryId, int cityId){
        this.addressName = addressName;
        this.countryId = countryId;
        this.countryId = cityId;
    }
}
