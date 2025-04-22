package com.mycom.myapp.cus.service;

import com.mycom.myapp.cus.dao.CusDao;
import com.mycom.myapp.cus.dto.CusDto;
import com.mycom.myapp.cus.dto.CusParamDto;
import com.mycom.myapp.cus.dto.CusResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusServiceImpl implements CusService {

    private final CusDao cusDao;

    public CusServiceImpl(CusDao cusDao) {
        this.cusDao = cusDao;
    }

    @Override
    public CusResultDto listCus(CusParamDto cusParamDto) { // limit, offset
        CusResultDto cusResultDto = new CusResultDto();

        // 예외 처리
        // 처리과정 중 오류 발생????
        //  1. 직접 제어 (사용)
        //  2. Spring Framework 처리 의뢰 / error mapping
        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<CusDto> list = cusDao.listCus(cusParamDto);
            int count = cusDao.listCusTotalCount();
            cusResultDto.setList(list);
            cusResultDto.setCount(count);
            cusResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            cusResultDto.setResult("fail");
        }
        return cusResultDto;
    }

    @Override
    public CusResultDto listCusSearchWord(CusParamDto cusParamDto) {
        CusResultDto cusResultDto = new CusResultDto();

        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<CusDto> list = cusDao.listCusSearchWord(cusParamDto);
            int count = cusDao.listCusSearchWordTotalCount(cusParamDto); // searchWord
            cusResultDto.setList(list);
            cusResultDto.setCount(count);
            cusResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            cusResultDto.setResult("fail");
        }
        return cusResultDto;
    }
}
