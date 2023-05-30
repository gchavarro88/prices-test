package com.prices.pricestest.dto;

import java.time.LocalDateTime;

public class PriceRequest {
    @NotBlank
    private LocalDateTime date;

    private Integer productId;

    private Integer brandId;

    public PriceRequest(LocalDateTime date, Integer productId, Integer brandId) {
        this.date = date;
        this.productId = productId;
        this.brandId = brandId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
