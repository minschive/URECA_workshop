package com.mycom.spring_data_jpa_phone.user.service;

import com.mycom.spring_data_jpa_phone.user.dto.UserResultDto;
import com.mycom.spring_data_jpa_phone.user.entity.User;

public interface UserService {
    UserResultDto insertUser(User user);
}
