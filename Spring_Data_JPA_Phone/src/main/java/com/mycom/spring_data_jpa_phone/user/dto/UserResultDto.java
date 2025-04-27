package com.mycom.spring_data_jpa_phone.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResultDto {
    private String result;
    private UserDto userDto;
    private List<UserDto> userList;
}
