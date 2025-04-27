package com.mycom.spring_data_jpa_phone.phone.controller;

import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import com.mycom.spring_data_jpa_phone.phone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/all")
    public List<PhoneDto> getAllPhones() {
        return phoneService.getAllPhones();
    }
}