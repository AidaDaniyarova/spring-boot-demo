package com.spring.java.demo.repositories;

import com.spring.java.demo.model.AssignmentsModel;
import com.spring.java.demo.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyModel, Long> {
}
