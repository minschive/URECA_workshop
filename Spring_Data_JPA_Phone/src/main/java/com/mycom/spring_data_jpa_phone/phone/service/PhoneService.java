package com.mycom.spring_data_jpa_phone.phone.service;

import com.mycom.spring_data_jpa_phone.apple.repository.AppleRepository;
import com.mycom.spring_data_jpa_phone.lg.repository.LgRepository;
import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import com.mycom.spring_data_jpa_phone.samsung.repository.SamsungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private SamsungRepository samsungRepository;

    @Autowired
    private AppleRepository appleRepository;

    @Autowired
    private LgRepository lgRepository;

    public List<PhoneDto> getAllPhones() {
        List<PhoneDto> allPhones = new ArrayList<>();

        allPhones.addAll(samsungRepository.findAllPhoneDetails());
        allPhones.addAll(appleRepository.findAllPhoneDetails());
        allPhones.addAll(lgRepository.findAllPhoneDetails());

        return allPhones;
    }

}
