package com.mycom.spring_data_jpa_phone.phone.controller;

import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import com.mycom.spring_data_jpa_phone.phone.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("/all")
    public List<PhoneDto> getAllPhones() {
        return phoneService.getAllPhones();
    }
}