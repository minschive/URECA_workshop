package com.mycom.spring_data_jpa_lombok_phone.auth.service;

import com.mycom.spring_data_jpa_lombok_phone.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
