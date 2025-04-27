package com.mycom.spring_data_jpa_phone.phone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneDto {

    private Long id;
    private String model;
    private String size;
    private String memory;
    private String price;
    private String manufacturer; // 브랜드 정보

}
