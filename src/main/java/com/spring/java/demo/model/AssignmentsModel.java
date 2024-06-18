package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASSIGNMENTS")
public class AssignmentsModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PROJECT_ID")
    private int projectID;
    @Column(name = "TASK")
    private String task;
    @Column(name = "IS_FINISHED")
    private boolean isFinished;
    @Column(name = "WORKED_HOURS")
    private int workedHours;

    public AssignmentsModel(int projectID, String task, boolean isFinished, int workedHours) {
        this.projectID = projectID;
        this.task = task;
        this.isFinished = isFinished;
        this.workedHours = workedHours;
    }
}
