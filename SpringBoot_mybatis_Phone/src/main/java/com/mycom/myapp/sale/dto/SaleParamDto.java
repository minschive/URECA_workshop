package com.mycom.myapp.sale.dto;

// client 가 server 에 게시글 관련 전달하는 파라미터
// Controller 에서 개별적인 파라미터를 사용할 수도 있지만, Dto 로 자동으로 처리하는 게 더 유지보수에 편리
public class SaleParamDto {
    // 목록
    private int limit;
    private int offset;
    private String searchWord;

    // 상세
    private int saleId;

    // 생성자 대신 setter 사용
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "SaleParamDto{" +
                "limit=" + limit +
                ", offset=" + offset +
                ", searchWord='" + searchWord + '\'' +
                ", saleId=" + saleId +
                '}';
    }
}
