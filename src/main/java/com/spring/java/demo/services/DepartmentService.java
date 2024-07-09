package com.spring.java.demo.services;

import com.spring.java.demo.model.AddressModel;
import com.spring.java.demo.model.DepartmentModel;
import com.spring.java.demo.repositories.DepartmentRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<DepartmentModel> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Optional<DepartmentModel> getDepartmentById(Long id) {
        return departmentRepo.findById(id);
    }

    public DepartmentModel createDepartment(DepartmentModel department) {
        return departmentRepo.save(department);
    }

    public DepartmentModel updateDepartment(Long id, DepartmentModel departmentDetails) {
        Optional<DepartmentModel> optionalDepartment = departmentRepo.findById(id);
        if (optionalDepartment.isPresent()) {
            DepartmentModel department = optionalDepartment.get();
            department.setDepartmentName(departmentDetails.getDepartmentName());
            department.setDescription(departmentDetails.getDescription());
            department.setEmployeeNumber(departmentDetails.getEmployeeNumber());
            department.setCompany(departmentDetails.getCompany());
            return departmentRepo.save(department);
        } else {
            throw new IllegalArgumentException("Department not found with id: " + id);
        }
    }

    public void deleteDepartment(Long id) {
        try {
            System.out.println("Deleting department with ID: " + id);
            departmentRepo.deleteById(id);
            System.out.println("Department deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting department with ID: " + id + " - " + e.getMessage());
            throw e;
        }
    }


    public boolean existsById(Long id) {
        return departmentRepo.existsById(id);
    }

    public DepartmentModel getDefaultDepartment() {
        return departmentRepo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Default department not found"));
    }
}
