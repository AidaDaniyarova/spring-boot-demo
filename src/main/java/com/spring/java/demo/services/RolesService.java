package com.spring.java.demo.services;

import com.spring.java.demo.model.RolesModel;
import com.spring.java.demo.repositories.RolesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    private final RolesRepo rolesRepo;

    public RolesService(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    public Optional<RolesModel> getRoleById(long id) {
        return rolesRepo.findById(id);
    }

    public boolean existsById(Long id) {
        return rolesRepo.existsById(id);
    }

    public RolesModel getDefaultRole() {
        return rolesRepo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Default role not found"));
    }

    public List<RolesModel> getAllRoles() {
        return rolesRepo.findAll();
    }
}
