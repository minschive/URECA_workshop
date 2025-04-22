package com.mycom.myapp.phone.controller;

import com.mycom.myapp.phone.dto.PhoneParamDto;
import com.mycom.myapp.phone.dto.PhoneResultDto;
import com.mycom.myapp.phone.service.PhoneService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/list") // limit, offset, searchWord 모두 한꺼번에 처리 ( service, dao layer 는 분리되어 있다. )
    @ResponseBody
    public PhoneResultDto listPhone(PhoneParamDto phoneParamDto) {

        PhoneResultDto phoneResultDto = null;

        if(Strings.isEmpty(phoneParamDto.getSearchWord())) { // 검색어가 없는 경우 (null, "")
            phoneResultDto = phoneService.listPhone(phoneParamDto); // limit, offset
        } else {
            phoneResultDto = phoneService.listPhoneSearchWord(phoneParamDto); // limit, offset, searchWord
        }

        return phoneResultDto;
    }
}
