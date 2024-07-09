package com.spring.java.demo.model;

import com.spring.java.demo.services.AddressService;
import com.spring.java.demo.services.AssignmentService;
import com.spring.java.demo.services.DepartmentService;
import com.spring.java.demo.services.RolesService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFILES")
public class ProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @SequenceGenerator(name = "profile_seq", sequenceName = "profiles_id_seq", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserModel user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressModel address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private RolesModel role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_ID")
    private AssignmentsModel assignment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentModel department;


    public ProfileModel(UserModel user, AddressModel address, RolesModel role, AssignmentsModel assignment, DepartmentModel department) {
        this.user = user;
        this.address = address;
        this.role = role;
        this.assignment = assignment;
        this.department = department;
    }

}

