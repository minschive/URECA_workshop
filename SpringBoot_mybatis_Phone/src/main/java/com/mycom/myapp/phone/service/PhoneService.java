package com.mycom.myapp.phone.service;

import com.mycom.myapp.phone.dto.PhoneParamDto;
import com.mycom.myapp.phone.dto.PhoneResultDto;

public interface PhoneService {
    PhoneResultDto listPhone(PhoneParamDto phoneParamDto); // limit, offset
    PhoneResultDto listPhoneSearchWord(PhoneParamDto phoneParamDto); // limit, offset, searchWord

//    PhoneResultDto detailPhone(PhoneParamDto phoneParamDto); // phoneId
}
