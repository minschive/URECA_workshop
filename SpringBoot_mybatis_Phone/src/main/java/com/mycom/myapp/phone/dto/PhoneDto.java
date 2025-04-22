package com.mycom.myapp.phone.dto;


import lombok.Builder;
import lombok.Data;

// board table 과 user table 의 조인 결과를 표현
// java 8 LocalDateTime ( client 에게 일시(일자, 시각) 관련 데이터를 년월일 시분초 로 쉽게 내려줄 수 있다. )
@Data
@Builder
public class PhoneDto {
    private int phoneId;
    private String brand;
    private String model;
    private int price;
    private int stock;

}
