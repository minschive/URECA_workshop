package com.mycom.myapp.phone.dao;

import com.mycom.myapp.phone.dto.PhoneDto;
import com.mycom.myapp.phone.dto.PhoneParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhoneDao {
    // 목록
    List<PhoneDto> listPhone(PhoneParamDto phoneParamDto);
    int listPhoneTotalCount();

    List<PhoneDto> listPhoneSearchWord(PhoneParamDto phoneParamDto); // limit, offset, searchWord
    int listPhoneSearchWordTotalCount(PhoneParamDto phoneParamDto); // searchWord

    // 상세
//    PhoneDto detailPhone(PhoneParamDto phoneParamDto); // boardId
}
