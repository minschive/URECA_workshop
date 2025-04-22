package com.mycom.myapp.sale.dto;

import java.util.List;

public class SaleResultDto {
    private String result; // 등록, 수정, 삭제 작업 성공, 실패
    private List<SaleDto> list; // 목록
    private SaleDto dto; // 상세
    private int count; // 목록 데이터 건수

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<SaleDto> getList() {
        return list;
    }

    public void setList(List<SaleDto> list) {
        this.list = list;
    }

    public SaleDto getDto() {
        return dto;
    }

    public void setDto(SaleDto dto) {
        this.dto = dto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SaleResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dto=" + dto +
                ", count=" + count +
                '}';
    }
}
