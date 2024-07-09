package com.spring.java.demo.controllers;

import com.spring.java.demo.model.DepartmentModel;
import com.spring.java.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/admin")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public String getDepartmentPage(Model model) {
        List<DepartmentModel> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/departments/create")
    public String getCreateDepartmentPage(Model model) {
        model.addAttribute("newDepartment", new DepartmentModel());
        return "create_department_page";
    }

    @PostMapping("/departments/createDepartment")
    public String createDepartment(@ModelAttribute DepartmentModel department) {
        departmentService.createDepartment(department);
        return "redirect:/rest/admin/departments";
    }

    @GetMapping("/departments/edit/{id}")
    public String getEditDepartmentPage(Model model, @PathVariable Long id) {
        DepartmentModel department = departmentService.getDepartmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department ID: " + id));
        model.addAttribute("departmentToEdit", department);
        return "edit_department_page";
    }

    @PostMapping("/departments/editDepartment")
    public String editDepartment(@ModelAttribute DepartmentModel department) {
        departmentService.updateDepartment(department.getId(), department);
        return "redirect:/rest/admin/departments";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Long id, Model model) {
        try {
            departmentService.deleteDepartment(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Cannot delete department with ID " + id + " because it is referenced by another entity.");
            return getDepartmentPage(model);
        }
        return "redirect:/rest/admin/departments";
    }
}
