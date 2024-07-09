package com.spring.java.demo.services;

import com.spring.java.demo.model.AddressModel;
import com.spring.java.demo.model.AssignmentsModel;
import com.spring.java.demo.repositories.AssignmentRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepo assignmentRepo;

    public AssignmentService(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    public List<AssignmentsModel> getAllAssignments() {
        return assignmentRepo.findAll();
    }

    public Optional<AssignmentsModel> getAssignmentById(Long id) {
        return assignmentRepo.findById(id);
    }

    public AssignmentsModel createAssignment(AssignmentsModel assignment) {
        return assignmentRepo.save(assignment);
    }

    public AssignmentsModel updateAssignment(Long id, AssignmentsModel assignmentDetails) {
        Optional<AssignmentsModel> optionalAssignment = assignmentRepo.findById(id);
        if (optionalAssignment.isPresent()) {
            AssignmentsModel assignment = optionalAssignment.get();
            assignment.setTask(assignmentDetails.getTask());
            assignment.setProject(assignmentDetails.getProject());
            assignment.setWorkedHours(assignmentDetails.getWorkedHours());
            assignment.setFinished(assignmentDetails.isFinished());
            return assignmentRepo.save(assignment);
        } else {
            throw new IllegalArgumentException("Assignment not found with id: " + id);
        }
    }

    public void deleteAssignment(Long id) {
        try {
            System.out.println("Deleting assignment with ID: " + id);
            assignmentRepo.deleteById(id);
            System.out.println("Assignment deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting assignment with ID: " + id + " - " + e.getMessage());
            throw e;
        }
    }


    public AssignmentsModel getDefaultAssignment() {
        return assignmentRepo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Default assignment not found"));
    }

    public boolean existsById(Long id) {
        return assignmentRepo.existsById(id);
    }
}
