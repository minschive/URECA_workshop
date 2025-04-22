package com.mycom.myapp.phone.service;

import com.mycom.myapp.phone.dao.PhoneDao;
import com.mycom.myapp.phone.dto.PhoneDto;
import com.mycom.myapp.phone.dto.PhoneParamDto;
import com.mycom.myapp.phone.dto.PhoneResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public PhoneResultDto listPhone(PhoneParamDto phoneParamDto) { // limit, offset
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        // 예외 처리
        // 처리과정 중 오류 발생????
        //  1. 직접 제어 (사용)
        //  2. Spring Framework 처리 의뢰 / error mapping
        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<PhoneDto> list = phoneDao.listPhone(phoneParamDto);
            int count = phoneDao.listPhoneTotalCount();
            phoneResultDto.setList(list);
            phoneResultDto.setCount(count);
            phoneResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }

    @Override
    public PhoneResultDto listPhoneSearchWord(PhoneParamDto phoneParamDto) {
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<PhoneDto> list = phoneDao.listPhoneSearchWord(phoneParamDto);
            int count = phoneDao.listPhoneSearchWordTotalCount(phoneParamDto); // searchWord
            phoneResultDto.setList(list);
            phoneResultDto.setCount(count);
            phoneResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }

}
