package com.mycom.spring_data_jpa_phone.user.controller;

import com.mycom.spring_data_jpa_phone.user.dto.UserResultDto;
import com.mycom.spring_data_jpa_phone.user.entity.User;
import com.mycom.spring_data_jpa_phone.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public UserResultDto insertUser(User user) {
        return userService.insertUser(user);
    }
}
