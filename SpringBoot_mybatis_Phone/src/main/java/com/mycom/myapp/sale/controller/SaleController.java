package com.mycom.myapp.sale.controller;

import com.mycom.myapp.sale.dto.SaleParamDto;
import com.mycom.myapp.sale.dto.SaleResultDto;
import com.mycom.myapp.sale.service.SaleService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/list") // limit, offset, searchWord 모두 한꺼번에 처리 ( service, dao layer 는 분리되어 있다. )
    @ResponseBody
    public SaleResultDto listSale(SaleParamDto saleParamDto) {

        SaleResultDto saleResultDto = null;

        if(Strings.isEmpty(saleParamDto.getSearchWord())) { // 검색어가 없는 경우 (null, "")
            saleResultDto = saleService.listSale(saleParamDto); // limit, offset
        } else {
            saleResultDto = saleService.listSaleSearchWord(saleParamDto); // limit, offset, searchWord
        }

        return saleResultDto;
    }
}
