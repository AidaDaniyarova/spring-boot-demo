package com.spring.java.demo.services;

import com.spring.java.demo.model.*;
import com.spring.java.demo.repositories.AddressRepo;
import com.spring.java.demo.repositories.ProfileRepo;
import com.spring.java.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepo profileRepo;
    private final UserRepo userRepo;
    private final AddressRepo addressRepo;
    private final UserService userService;
    private final DepartmentService departmentService;
    private final RolesService rolesService;
    private final AddressService addressService;
    private final AssignmentService assignmentService;

    public ProfileService(ProfileRepo profileRepo, UserRepo userRepo, AddressRepo addressRepo, UserService userService, DepartmentService departmentService, RolesService rolesService, AddressService addressService, AssignmentService assignmentService) {
        this.profileRepo = profileRepo;
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
        this.userService = userService;
        this.departmentService = departmentService;
        this.rolesService = rolesService;
        this.addressService = addressService;
        this.assignmentService = assignmentService;
    }

    public ProfileModel getProfileByUserId(Long userId) {
        ProfileModel profile = profileRepo.findProfileByUserId(userId);
        return profile;
    }

    public ProfileModel createProfile(ProfileModel profile) {
        return profileRepo.save(profile);
    }

    public Optional<ProfileModel> getProfileById(Long id) {
        return profileRepo.findById(id);
    }

    public ProfileModel updateProfile(Long id, ProfileModel profileDetails) {
        Optional<ProfileModel> optionalProfile = profileRepo.findById(id);
        if (optionalProfile.isPresent()) {
            ProfileModel profile = optionalProfile.get();
            if (!optionalProfile.get().getRole().getId().equals(profileDetails.getRole().getId())) {
                profile.setRole(profileDetails.getRole());
            }
            if (!optionalProfile.get().getUser().getId().equals(profileDetails.getUser().getId())) {
                profile.setUser(profileDetails.getUser());
            }
            if (!optionalProfile.get().getDepartment().getId().equals(profileDetails.getDepartment().getId())) {
                profile.setDepartment(profileDetails.getDepartment());
            }
            if (!optionalProfile.get().getAddress().getId().equals(profileDetails.getAddress().getId())) {
                profile.setAddress(profileDetails.getAddress());
            }
            if (!optionalProfile.get().getAssignment().getId().equals(profileDetails.getAssignment().getId())) {
                profile.setAssignment(profileDetails.getAssignment());
            }
            return profileRepo.save(profile);
        } else {
            throw new IllegalArgumentException("Profile not found with id: " + id);
        }
    }

    public void deleteProfile(Long id) {
        try {
            System.out.println("Deleting Profile with ID: " + id);
            profileRepo.deleteById(id);
            System.out.println("Profile deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting Profile with ID: " + id + " - " + e.getMessage());
            throw e;
        }
    }
}
