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
@Table(name = "PROJECTS")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROJECT_NAME", nullable = false)
    private String projectName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "STATUS_ID", nullable = false)
    private int statusID;

    public ProjectModel(String projectName, String description, Date startDate, Date endDate, int statusID) {
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusID = statusID;
    }
}
