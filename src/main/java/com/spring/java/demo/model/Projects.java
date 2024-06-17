package com.spring.java.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
    private int id;
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;
    private int statusID;
}
