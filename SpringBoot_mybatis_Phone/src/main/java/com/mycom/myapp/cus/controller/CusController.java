package com.mycom.myapp.cus.controller;

import com.mycom.myapp.cus.dto.CusParamDto;
import com.mycom.myapp.cus.dto.CusResultDto;
import com.mycom.myapp.cus.service.CusService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cuss")
public class CusController {

    private final CusService cusService;

    public CusController(CusService cusService) {
        this.cusService = cusService;
    }

    @GetMapping("/list") // limit, offset, searchWord 모두 한꺼번에 처리 ( service, dao layer 는 분리되어 있다. )
    @ResponseBody
    public CusResultDto listCus(CusParamDto cusParamDto) {

        CusResultDto cusResultDto = null;

        if(Strings.isEmpty(cusParamDto.getSearchWord())) { // 검색어가 없는 경우 (null, "")
            cusResultDto = cusService.listCus(cusParamDto); // limit, offset
        } else {
            cusResultDto = cusService.listCusSearchWord(cusParamDto); // limit, offset, searchWord
        }

        return cusResultDto;
    }
}
