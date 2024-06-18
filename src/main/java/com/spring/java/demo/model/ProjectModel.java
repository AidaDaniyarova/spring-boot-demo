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
@Table(name = "PROJECT")
public class ProjectModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "STATUS_ID")
    private int statusID;

    public ProjectModel(String projectName, String description, Date startDate, Date endDate, int statusID) {
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusID = statusID;
    }
}
