package com.mycom.myapp.sale.service;


import com.mycom.myapp.sale.dto.SaleParamDto;
import com.mycom.myapp.sale.dto.SaleResultDto;

public interface SaleService {
    SaleResultDto listSale(SaleParamDto saleParamDto); // limit, offset
    SaleResultDto listSaleSearchWord(SaleParamDto saleParamDto); // limit, offset, searchWord
}
