package com.spring.java.demo.controllers;

import com.spring.java.demo.model.ProjectModel;
import com.spring.java.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/admin")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public String getProjectPage(Model model) {
        List<ProjectModel> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/create")
    public String getCreateProjectPage(Model model) {
        model.addAttribute("newProject", new ProjectModel());
        return "create_project_page";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute ProjectModel project) {
        projectService.createProject(project);
        return "redirect:/rest/admin/projects";
    }

    @GetMapping("/edit/{id}")
    public String getEditProjectPage(Model model, @PathVariable Long id) {
        ProjectModel project = projectService.getProjectById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID: " + id));
        model.addAttribute("projectToEdit", project);
        return "edit_project_page";
    }

    @PostMapping("/editProject")
    public String editProject(@ModelAttribute ProjectModel project) {
        projectService.updateProject(project.getId(), project);
        return "redirect:/rest/admin/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/rest/admin/projects";
    }
}
