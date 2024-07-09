package com.spring.java.demo.repositories;

import com.spring.java.demo.model.ProfileModel;
import com.spring.java.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileModel, Long> {
    @Query("SELECT u FROM ProfileModel u WHERE u.user.id = :userId")
    ProfileModel findProfileByUserId(@Param("userId") Long userId);
}
