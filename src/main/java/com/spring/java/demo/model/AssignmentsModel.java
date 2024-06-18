package com.spring.java.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentsModel {
    private int id;
    private int projectID;
    private String task;
    private boolean isFinished;
    private int workedHours;
}
