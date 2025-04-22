package com.mycom.myapp.sale.dao;

import com.mycom.myapp.sale.dto.SaleDto;
import com.mycom.myapp.sale.dto.SaleParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleDao {
    // 목록
    List<SaleDto> listSale(SaleParamDto saleParamDto);
    int listSaleTotalCount();

    List<SaleDto> listSaleSearchWord(SaleParamDto saleParamDto); // limit, offset, searchWord
    int listSaleSearchWordTotalCount(SaleParamDto saleParamDto); // searchWord
}
