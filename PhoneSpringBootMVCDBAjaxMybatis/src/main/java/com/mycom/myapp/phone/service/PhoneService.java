package com.mycom.myapp.phone.service;

import com.mycom.myapp.phone.dto.PhoneDto;

import java.util.List;

public interface PhoneService {
    List<PhoneDto> listPhone();
    PhoneDto detailPhone(int phoneId);
    int insertPhone(PhoneDto phoneDto);
    int updatePhone(PhoneDto pHoneDto);
    int deletePhone(int phoneId);
}
