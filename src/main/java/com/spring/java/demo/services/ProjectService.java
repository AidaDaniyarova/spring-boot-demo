package com.spring.java.demo.services;

import com.spring.java.demo.model.ProjectModel;
import com.spring.java.demo.repositories.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<ProjectModel> getAllProjects() {
        return projectRepo.findAll();
    }

    public Optional<ProjectModel> getProjectById(Long id) {
        return projectRepo.findById(id);
    }

    public ProjectModel createProject(ProjectModel project) {
        return projectRepo.save(project);
    }

    public ProjectModel updateProject(Long id, ProjectModel projectDetails) {
        Optional<ProjectModel> optionalProject = projectRepo.findById(id);
        if (optionalProject.isPresent()) {
            ProjectModel project = optionalProject.get();
            project.setProjectName(projectDetails.getProjectName());
            project.setDescription(projectDetails.getDescription());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            project.setStatus(projectDetails.getStatus());
            return projectRepo.save(project);
        } else {
            throw new IllegalArgumentException("Project not found with id: " + id);
        }
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}