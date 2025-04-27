package com.mycom.spring_data_jpa_phone.user.repository;

import com.mycom.spring_data_jpa_phone.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByName(String name);
}
