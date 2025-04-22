package com.mycom.myapp.phone.dto;

import java.util.List;

public class PhoneResultDto {
    private String result; // 등록, 수정, 삭제 작업 성공, 실패
    private List<PhoneDto> list; // 목록
    private PhoneDto dto; // 상세
    private int count; // 목록 데이터 건수

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PhoneDto> getList() {
        return list;
    }

    public void setList(List<PhoneDto> list) {
        this.list = list;
    }

    public PhoneDto getDto() {
        return dto;
    }

    public void setDto(PhoneDto dto) {
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
        return "BoardResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dto=" + dto +
                ", count=" + count +
                '}';
    }
}
