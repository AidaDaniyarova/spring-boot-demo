package com.spring.java.demo.controllers;

import com.spring.java.demo.model.AssignmentsModel;
import com.spring.java.demo.model.ProfileModel;
import com.spring.java.demo.model.ProjectModel;
import com.spring.java.demo.repositories.UserRepo;
import com.spring.java.demo.services.AssignmentService;
import com.spring.java.demo.services.ProfileService;
import com.spring.java.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rest/admin")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/assignments")
    public String getAssignmentPage(Model model) {
        List<AssignmentsModel> assignments = assignmentService.getAllAssignments();
        model.addAttribute("assignments", assignments);
        return "assignments";
    }

    @GetMapping("/assignments/create")
    public String getCreateAssignmentPage(Model model) {
        model.addAttribute("newAssignment", new AssignmentsModel());
        return "create_assignment_page";
    }

    @PostMapping("/assignments/createAssignment")
    public String createAssignment(@ModelAttribute AssignmentsModel assignment) {
        assignmentService.createAssignment(assignment);
        return "redirect:/rest/admin/assignments";
    }

    @GetMapping("/assignments/edit/{id}")
    public String getEditAssignmentPage(Model model, @PathVariable Long id) {
        AssignmentsModel assignment = assignmentService.getAssignmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid assignment ID: " + id));
        model.addAttribute("assignmentToEdit", assignment);
        return "edit_assignment_page";
    }

    @PostMapping("/assignments/editAssignment")
    public String editAssignment(@ModelAttribute AssignmentsModel assignment) {
        assignmentService.updateAssignment(assignment.getId(), assignment);
        return "redirect:/rest/admin/assignments";
    }

    @GetMapping("/assignments/delete/{id}")
    public String deleteAssignment(@PathVariable Long id, Model model) {
        try {
            assignmentService.deleteAssignment(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Cannot delete assignment with ID " + id + " because it is referenced by another entity.");
            return getAssignmentPage(model);
        }
        return "redirect:/rest/admin/assignments";
    }
}
