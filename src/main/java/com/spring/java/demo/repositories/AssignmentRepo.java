package com.spring.java.demo.repositories;

import com.spring.java.demo.model.AssignmentsModel;
import com.spring.java.demo.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<AssignmentsModel, Long> {
    @Query("SELECT u FROM AssignmentsModel u WHERE u.id = :id")
    AssignmentsModel findAssignmentById(@Param("id") Long id);
}
