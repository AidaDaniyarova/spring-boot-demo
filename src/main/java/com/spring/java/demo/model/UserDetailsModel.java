package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PROFILE_ID")
    private int profileID;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GENDER_ID", nullable = false)
    private GenderModel gender;

    public UserDetailsModel(int profileID, Date dateOfBirth, GenderModel gender) {
        this.profileID = profileID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
