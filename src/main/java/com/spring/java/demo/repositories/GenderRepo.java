package com.spring.java.demo.repositories;

import com.spring.java.demo.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo  extends JpaRepository<GenderModel, Long> {
}
