package com.mycom.myapp.sale.service;

import com.mycom.myapp.sale.dao.SaleDao;
import com.mycom.myapp.sale.dto.SaleDto;
import com.mycom.myapp.sale.dto.SaleParamDto;
import com.mycom.myapp.sale.dto.SaleResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleDao saleDao;

    public SaleServiceImpl(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public SaleResultDto listSale(SaleParamDto saleParamDto) { // limit, offset
        SaleResultDto saleResultDto = new SaleResultDto();

        // 예외 처리
        // 처리과정 중 오류 발생????
        //  1. 직접 제어 (사용)
        //  2. Spring Framework 처리 의뢰 / error mapping
        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<SaleDto> list = saleDao.listSale(saleParamDto);
            int count = saleDao.listSaleTotalCount();
            saleResultDto.setList(list);
            saleResultDto.setCount(count);
            saleResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            saleResultDto.setResult("fail");
        }
        return saleResultDto;
    }

    @Override
    public SaleResultDto listSaleSearchWord(SaleParamDto saleParamDto) {
        SaleResultDto saleResultDto = new SaleResultDto();

        try {
            // Controller 는 PhoneService 의 listPhone() 1회 호출
            // PhoneService 는 PhoneDao 의 listPhone() 와 listPhoneSearchWord() 2개 호출
            List<SaleDto> list = saleDao.listSaleSearchWord(saleParamDto);
            int count = saleDao.listSaleSearchWordTotalCount(saleParamDto); // searchWord
            saleResultDto.setList(list);
            saleResultDto.setCount(count);
            saleResultDto.setResult("success");
        } catch(Exception e) {
            e.printStackTrace();
            saleResultDto.setResult("fail");
        }
        return saleResultDto;
    }
}
