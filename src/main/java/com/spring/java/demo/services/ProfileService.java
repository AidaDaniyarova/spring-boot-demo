package com.spring.java.demo.services;

import com.spring.java.demo.model.ProfileModel;
import com.spring.java.demo.model.UserModel;
import com.spring.java.demo.repositories.ProfileRepo;
import com.spring.java.demo.repositories.UserRepo;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepo profileRepo;
    public ProfileService(ProfileRepo profileRepo){
        this.profileRepo = profileRepo;
    }

    public ProfileModel getProfileByUserId(int userId){
        ProfileModel profile = profileRepo.findProfileByUserId(userId);
        return profile;
    }

    public ProfileModel createProfile(ProfileModel profile){
        ProfileModel newProfile = profileRepo.save(profile);
        profileRepo.flush();
        return newProfile;
    }
}
