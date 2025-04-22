package com.mycom.myapp.sale.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleDto {

    // 기본 판매 정보
    private int saleId;
    private int userId;
    private int phoneId;
    private int quantity;
    private BigDecimal totalPrice;
    private String saleDate;

    // 추가로 조인해서 가져올 사용자 이름과 휴대폰 모델명
    private String userName;
    private String model;

    public SaleDto() {
    }

    public SaleDto(int phoneId, int userId, int saleId, int quantity, BigDecimal totalPrice, String saleDate, String userName, String model) {
        this.phoneId = phoneId;
        this.userId = userId;
        this.saleId = saleId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
        this.userName = userName;
        this.model = model;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "saleId=" + saleId +
                ", userId=" + userId +
                ", phoneId=" + phoneId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", saleDate=" + saleDate +
                ", userName='" + userName + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}