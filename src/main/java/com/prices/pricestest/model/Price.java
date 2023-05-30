package com.prices.pricestest.model;


import com.prices.pricestest.utilities.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Currency curr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_list_id", nullable = false)
    private PriceList priceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer priority;

    public Price() {}

    public Price(Brand brand, LocalDateTime startDate, LocalDateTime endDate, Double price, Currency curr,
                 PriceList priceList, Product product, Integer priority) {
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.curr = curr;
        this.priceList = priceList;
        this.product = product;
        this.priority = priority;
    }

    public Price(Integer id, Brand brand, LocalDateTime startDate, LocalDateTime endDate, Double price, Currency curr,
                 PriceList priceList, Product product, Integer priority) {
        this.id = id;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.curr = curr;
        this.priceList = priceList;
        this.product = product;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
