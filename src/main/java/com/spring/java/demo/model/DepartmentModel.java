package com.spring.java.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {
    private int id;
    private String departmentName;
    private String description;
    private int employeeNumber;
    private int companyId;

}
