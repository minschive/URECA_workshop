package com.mycom.myapp.cus.service;

import com.mycom.myapp.cus.dto.CusParamDto;
import com.mycom.myapp.cus.dto.CusResultDto;

public interface CusService {
    CusResultDto listCus(CusParamDto cusParamDto); // limit, offset
    CusResultDto listCusSearchWord(CusParamDto cusParamDto); // limit, offset, searchWord
}
