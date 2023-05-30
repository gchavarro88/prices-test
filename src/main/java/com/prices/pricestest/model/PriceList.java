package com.prices.pricestest.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceListId;

    private Double fee;

    public PriceList(Double fee) {
        this.fee = fee;
    }

    public PriceList(Integer priceListId, Double fee) {
        this.priceListId = priceListId;
        this.fee = fee;
    }

    public PriceList() {}

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
