package com.spring.java.demo.controllers;

import com.spring.java.demo.model.*;
import com.spring.java.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/admin")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RolesService rolesService;

    @GetMapping("/profile/{id}")
    public String getProfilePage(Model model, @PathVariable Long id) {
        ProfileModel profile = profileService.getProfileByUserId(id);
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String getEditProfilePage(Model model, @PathVariable Long id) {
        ProfileModel profile = profileService.getProfileById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid profile ID: " + id));

        List<UserModel> users = userService.getAllUsers();
        List<AddressModel> addresses = addressService.getAllAddresses();
        List<AssignmentsModel> assignments = assignmentService.getAllAssignments();
        List<DepartmentModel> departments = departmentService.getAllDepartments();
        List<RolesModel> roles = rolesService.getAllRoles();

        model.addAttribute("profileToEdit", profile);
        model.addAttribute("users", users);
        model.addAttribute("addresses", addresses);
        model.addAttribute("assignments", assignments);
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
        return "edit_profile_page";
    }

    @PostMapping("/profile/editProfile")
    public String editProfile(@ModelAttribute ProfileModel profile) {
        profileService.updateProfile(profile.getId(), profile);
        return "redirect:/rest/admin/profile/"+profile.getId().toString();
    }
}
