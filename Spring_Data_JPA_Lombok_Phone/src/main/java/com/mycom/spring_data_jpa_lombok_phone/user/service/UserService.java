package com.mycom.spring_data_jpa_lombok_phone.user.service;

import com.mycom.spring_data_jpa_lombok_phone.user.dto.UserDto;
import com.mycom.spring_data_jpa_lombok_phone.user.dto.UserResultDto;

// UserResultDto 만들어서 리턴
public interface UserService {
    UserResultDto registerUser(UserDto userDto);
}
