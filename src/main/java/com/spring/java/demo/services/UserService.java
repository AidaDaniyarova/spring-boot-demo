package com.spring.java.demo.services;

import com.spring.java.demo.model.UserModel;
import com.spring.java.demo.repositories.ProfileRepo;
import com.spring.java.demo.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final ProfileRepo profileRepo;
    public UserService(UserRepo userRepo, ProfileRepo profileRepo){
        this.userRepo = userRepo;
        this.profileRepo = profileRepo;
    }

    public UserModel getUserByEmail(String email){
        UserModel user = userRepo.findUserByEmail(email);
        return user;
    }

    public UserModel createUser(UserModel user){
        UserModel newUser = userRepo.save(user);
        userRepo.flush();
        return newUser;
    }

    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public UserModel updateUser(Long id, UserModel userDetails) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setEmail(userDetails.getEmail());
            user.setRoles(userDetails.getRoles());
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        try {
            System.out.println("Deleting User with ID: " + id);
            profileRepo.deleteById(profileRepo.findProfileByUserId(id).getId());
            userRepo.deleteById(id);
            System.out.println("User deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting User with ID: " + id + " - " + e.getMessage());
            throw e;
        }
    }

    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }
}
