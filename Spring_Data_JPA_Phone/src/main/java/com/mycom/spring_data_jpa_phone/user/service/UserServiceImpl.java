package com.mycom.spring_data_jpa_phone.user.service;

import com.mycom.spring_data_jpa_phone.user.dto.UserResultDto;
import com.mycom.spring_data_jpa_phone.user.entity.User;
import com.mycom.spring_data_jpa_phone.user.entity.UserRole;
import com.mycom.spring_data_jpa_phone.user.repository.UserRepository;
import com.mycom.spring_data_jpa_phone.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserResultDto insertUser(User user) {
        UserResultDto userResultDto = new UserResultDto();

        try {
            UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
            if (userRole == null) {
                userResultDto.setResult("fail");
                return userResultDto;
            }

            List<UserRole> userRoles = List.of(userRole);
            user.setUserRoles(userRoles);
            User savedUser = userRepository.save(user);

            userResultDto.setResult("success");

        } catch (Exception e) {
            userResultDto.setResult("fail");
        }

        return userResultDto;
    }
}
