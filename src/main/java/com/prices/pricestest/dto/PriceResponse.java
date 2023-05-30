package com.prices.pricestest.dto;

import java.time.LocalDateTime;

public class PriceResponse {

    private Integer productId;

    private Integer brandId;

    private Double normalPrice;

    private Double fee;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double finalPrice;

    public PriceResponse(Integer productId, Integer brandId, Double fee, LocalDateTime startDate,
                         LocalDateTime endDate, Double finalPrice, Double normalPrice) {
        this.productId = productId;
        this.brandId = brandId;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
        this.normalPrice = normalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }
}
