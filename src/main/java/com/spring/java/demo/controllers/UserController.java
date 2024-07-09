package com.spring.java.demo.controllers;

import com.spring.java.demo.model.UserModel;
import com.spring.java.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUserPage(Model model) {
        List<UserModel> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/users/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new UserModel());
        return "create_user_page";
    }

    @PostMapping("/users/createUser")
    public String createUser(@ModelAttribute UserModel user) {
        userService.createUser(user);
        return "redirect:/rest/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String getEditUserPage(Model model, @PathVariable Long id) {
        UserModel user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("userToEdit", user);
        return "edit_user_page";
    }

    @PostMapping("/users/editUser")
    public String editUser(@ModelAttribute UserModel user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/rest/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Cannot delete user with ID " + id + " because it is referenced by another entity.");
            return getUserPage(model);
        }
        return "redirect:/rest/admin/users";
    }
}
