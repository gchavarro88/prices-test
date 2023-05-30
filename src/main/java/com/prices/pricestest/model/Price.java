package com.prices.pricestest.model;


import com.prices.pricestest.utilities.Currency;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {

    private Integer brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;

    private Currency curr;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    public Price(Integer brandId, LocalDateTime startDate, LocalDateTime endDate, Double price, Currency curr,
                 Integer priceList, Integer productId, Integer priority) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.curr = curr;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurr() {
        return curr;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
