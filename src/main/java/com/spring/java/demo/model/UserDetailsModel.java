package com.spring.java.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsModel {
    private int id;
    private int profileID;
    private Date dateOfBirth;
    private int genderId;
}
