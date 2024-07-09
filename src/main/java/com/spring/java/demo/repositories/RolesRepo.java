package com.spring.java.demo.repositories;

import com.spring.java.demo.model.AddressModel;
import com.spring.java.demo.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<RolesModel, Long> {
}
