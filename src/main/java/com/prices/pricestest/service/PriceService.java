package com.prices.pricestest.service;

import com.prices.pricestest.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


public interface PriceService {
    public Optional<PriceResponse> getFinalPrice(Integer brandId, Integer productId, LocalDateTime date);
}
