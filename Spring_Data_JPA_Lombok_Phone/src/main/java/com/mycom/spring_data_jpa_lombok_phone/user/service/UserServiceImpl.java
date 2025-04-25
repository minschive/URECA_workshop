package com.mycom.spring_data_jpa_lombok_phone.user.service;

import com.mycom.spring_data_jpa_lombok_phone.user.dto.UserDto;
import com.mycom.spring_data_jpa_lombok_phone.user.dto.UserResultDto;
import com.mycom.spring_data_jpa_lombok_phone.user.entity.User;
import com.mycom.spring_data_jpa_lombok_phone.user.entity.UserRole;
import com.mycom.spring_data_jpa_lombok_phone.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResultDto registerUser(UserDto userDto) {
       User user = new User();
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());

        Set<UserRole> roles = new HashSet<>();
        if (userDto.getRoles() != null) {
            for (String roleName : userDto.getRoles().values()) {
                UserRole role = new UserRole();
                role.setName(roleName);
                roles.add(role);
            }
        }
        user.setUserRoles(roles);

        User savedUser = userRepository.save(user);

        UserDto resultDto = UserDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();

        UserResultDto userResultDto = new UserResultDto();
        userResultDto.setResult("success");
        userResultDto.setUserDto(resultDto);

        return userResultDto;
    }
}
