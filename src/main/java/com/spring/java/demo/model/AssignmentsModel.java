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
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private ProjectModel project;
    @Column(name = "TASK")
    private String task;
    @Column(name = "IS_FINISHED")
    private boolean finished;
    @Column(name = "WORKED_HOURS")
    private int workedHours;
    public AssignmentsModel(ProjectModel project, String task, boolean finished, int workedHours) {
        this.project = project;
        this.task = task;
        this.finished = finished;
        this.workedHours = workedHours;
    }
}
