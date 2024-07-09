package com.spring.java.demo.repositories;

import com.spring.java.demo.model.DepartmentModel;
import com.spring.java.demo.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentModel, Long> {


}
