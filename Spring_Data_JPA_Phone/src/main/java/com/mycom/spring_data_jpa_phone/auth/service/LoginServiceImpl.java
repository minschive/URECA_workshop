package com.mycom.spring_data_jpa_phone.auth.service;

import com.mycom.spring_data_jpa_phone.user.dto.UserDto;
import com.mycom.spring_data_jpa_phone.user.dto.UserResultDto;
import com.mycom.spring_data_jpa_phone.user.entity.User;
import com.mycom.spring_data_jpa_phone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public UserResultDto login(String email, String password) {

        UserResultDto userResultDto = new UserResultDto();

        log.debug("login() 시작");

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if( optionalUser.isPresent() ) {

            User user = optionalUser.get();
            if ( user.getPassword().equals(password) ) {
                // User -> UserDto
                // UserRole 도 함께 처리
                Map<Integer, String> roles = new HashMap<>();
                user.getUserRoles().forEach(userRole -> roles.put(userRole.getId(), userRole.getName()) );

                UserDto userDto = UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .roles(roles)
                        .build();

                userResultDto.setUserDto(userDto);
                userResultDto.setResult("success");
            } else {
                userResultDto.setResult("fail");
            }

        } else {
            userResultDto.setResult("notfound");
        }

        log.debug("login() 종료");

        return userResultDto;
    }
}
