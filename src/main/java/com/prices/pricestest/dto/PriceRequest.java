package com.prices.pricestest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PriceRequest {
    @NotNull(message = "Please insert a valid date with the next format. e.g. 2018-12-30T19:34:50.63")
    private LocalDateTime date;

    @NotNull(message = "Please insert a valid numeric value for product id e.g. 1")
    @Min(message = "Brand id should be greater than 0", value = 1L)
    private Integer productId;

    @NotNull(message = "Please insert a valid numeric value for brand id e.g. 1")
    @Min(message = "Brand id should be greater than 0", value = 1L)
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
