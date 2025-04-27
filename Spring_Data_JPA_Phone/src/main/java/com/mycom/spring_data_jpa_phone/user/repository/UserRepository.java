package com.mycom.spring_data_jpa_phone.user.repository;

import com.mycom.spring_data_jpa_phone.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.userRoles where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
