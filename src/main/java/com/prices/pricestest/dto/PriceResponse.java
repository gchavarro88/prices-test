package com.prices.pricestest.dto;

import java.time.LocalDateTime;

public class PriceResponse {

    private Integer productId;

    private Integer brandId;

    private Integer fee;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double finalPrice;

    public PriceResponse(Integer productId, Integer brandId, Integer fee, LocalDateTime startDate, LocalDateTime endDate, Double finalPrice) {
        this.productId = productId;
        this.brandId = brandId;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
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

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
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
}
