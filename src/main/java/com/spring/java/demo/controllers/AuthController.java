package com.spring.java.demo.controllers;

import com.spring.java.demo.auth.JwtUtil;
import com.spring.java.demo.model.*;
import com.spring.java.demo.repositories.ProfileRepo;
import com.spring.java.demo.repositories.UserRepo;
import com.spring.java.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/rest/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepo userRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepo userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserModel());
        return "registration_page";
    }

    @PostMapping("/register")
    public String register(UserModel user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userService.createUser(user);
        AddressModel address = addressService.getAddressById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid address ID: "));
        RolesModel role = rolesService.getRoleById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid role ID: "));
        AssignmentsModel assignment = assignmentService.getAssignmentById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid assignment ID: "));
        DepartmentModel department = departmentService.getDepartmentById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid department ID: "));
        ProfileModel profile = new ProfileModel(user, address, role, assignment, department);
        profileService.createProfile(profile);
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            ProfileModel profile = profileService.getProfileByUserId(userRepository.findUserByEmail(email).getId());
            model.addAttribute("profile", profile);
            if(userRepository.findUserByEmail(email).getRoles().equals("ADMIN")) {
                return "admin_page"; // Redirect to loginSuccess.html on successful login
            }
            else{
                return "user_page";
            }
        } catch (BadCredentialsException e) {
            model.addAttribute("error", "Invalid username or password");
            return "login_page"; // Redirect back to login_page.html on failure
        }
    }

    /*@PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()));
            String email = authentication.getName();
            User user = new User(email, "");
            String token = jwtUtil.createToken(user);
            LoginResponse loginResponse = new LoginResponse(email, token);

            return "book_page";
        } catch (BadCredentialsException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return "login_page";
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return "error";
        }
        *//*user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userService.createUser(user);
        return "book_page"; // Redirect to registrationSuccess.html on successful registration*//*
    }*/
}
