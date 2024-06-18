package com.spring.java.demo.repositories;

import com.spring.java.demo.model.AddressModel;
import com.spring.java.demo.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo {
    @Query("SELECT u FROM AddressModel u WHERE u.email = :email")
    UserModel findUserByEmail(@Param("email") String email);
}
