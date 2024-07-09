package com.spring.java.demo.services;

import com.spring.java.demo.model.CompanyModel;
import com.spring.java.demo.repositories.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<CompanyModel> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Optional<CompanyModel> getCompanyById(Long id) {
        return companyRepo.findById(id);
    }

    public CompanyModel createCompany(CompanyModel company) {
        return companyRepo.save(company);
    }

    public CompanyModel updateCompany(Long id, CompanyModel companyDetails) {
        Optional<CompanyModel> optionalCompany = companyRepo.findById(id);
        if (optionalCompany.isPresent()) {
            CompanyModel company = optionalCompany.get();
            company.setCompanyName(companyDetails.getCompanyName());
            company.setDescription(companyDetails.getDescription());
            return companyRepo.save(company);
        } else {
            throw new IllegalArgumentException("Company not found with id: " + id);
        }
    }

    public void deleteCompany(Long id) {
        try {
            System.out.println("Deleting company with ID: " + id);
            companyRepo.deleteById(id);
            System.out.println("Company deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting company with ID: " + id + " - " + e.getMessage());
            throw e;
        }
    }
}
