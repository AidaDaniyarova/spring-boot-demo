package com.spring.java.demo.services;

import com.spring.java.demo.model.UserModel;
import com.spring.java.demo.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepository;
    public UserService(UserRepo userRepository){
        this.userRepository = userRepository;
    }

    public UserModel getUserByEmail(String email){
        UserModel user = userRepository.findUserByEmail(email);
        return user;
    }

    public UserModel createUser(UserModel user){
        UserModel newUser = userRepository.save(user);
        userRepository.flush();
        return newUser;
    }
}
