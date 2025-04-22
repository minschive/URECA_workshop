package com.mycom.myapp.cus.dao;

import com.mycom.myapp.cus.dto.CusDto;
import com.mycom.myapp.cus.dto.CusParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CusDao {
    // 목록
    List<CusDto> listCus(CusParamDto CusParamDto);
    int listCusTotalCount();

    List<CusDto> listCusSearchWord(CusParamDto CusParamDto); // limit, offset, searchWord
    int listCusSearchWordTotalCount(CusParamDto CusParamDto); // searchWord
}
