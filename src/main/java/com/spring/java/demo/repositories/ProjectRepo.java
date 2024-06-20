package com.spring.java.demo.repositories;

import com.spring.java.demo.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectModel, Long> {
}
