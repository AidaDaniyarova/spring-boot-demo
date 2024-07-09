package com.spring.java.demo.controllers;

import com.spring.java.demo.model.CompanyModel;
import com.spring.java.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/rest/admin")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public String getCompanyPage(Model model) {
        List<CompanyModel> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company";
    }

    @GetMapping("/company/create")
    public String getCreateCompanyPage(Model model) {
        model.addAttribute("newCompany", new CompanyModel());
        return "create_company_page";
    }

    @PostMapping("/company/createCompany")
    public String createCompany(@ModelAttribute CompanyModel company) {
        companyService.createCompany(company);
        return "redirect:/rest/admin/company";
    }

    @GetMapping("/company/edit/{id}")
    public String getEditCompanyPage(Model model, @PathVariable Long id) {
        CompanyModel company = companyService.getCompanyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID: " + id));
        model.addAttribute("companyToEdit", company);
        return "edit_company_page";
    }

    @PostMapping("/company/editCompany")
    public String editCompany(@ModelAttribute CompanyModel company) {
        companyService.updateCompany(company.getId(), company);
        return "redirect:/rest/admin/company";
    }

    @GetMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable Long id, Model model) {
        try {
            companyService.deleteCompany(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Cannot delete company with ID " + id + " because it is referenced by another entity.");
            return getCompanyPage(model);
        }
        return "redirect:/rest/admin/company";
    }
}
