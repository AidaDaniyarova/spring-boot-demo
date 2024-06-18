package com.spring.java.demo.repositories;

import com.spring.java.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.email = :email")
    UserModel findUserByEmail(@Param("email") String email);
}
