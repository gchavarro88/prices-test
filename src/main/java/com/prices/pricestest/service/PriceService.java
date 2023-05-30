package com.prices.pricestest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prices.pricestest.dto.PriceResponse;
import com.prices.pricestest.model.Price;
import com.prices.pricestest.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;


    public Optional<PriceResponse> getFinalPrice(Integer brandId, Integer productId, LocalDateTime date) {

        List<Price> prices = priceRepository
                .findByBrandIdAndProductIdAndBetweenStartAndEndDates(brandId, productId, date);

        if (prices != null && !prices.isEmpty()) {
            return Optional.of(priceResponseMapper(prices.get(0)));
        }

        return Optional.empty();
    }

    /**
     * Responsible to map a Price object to PriceResponse object
     * @param price
     * @return PriceResponse object
     */
    private PriceResponse priceResponseMapper(Price price) {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Double discount = (price.getPrice() *  price.getPriceList().getFee());
        Double finalPrice = price.getPrice() - discount;

        return new PriceResponse(
                price.getProduct().getProductId(),
                price.getBrand().getBrandId(),
                price.getPriceList().getFee(),
                price.getStartDate(),
                price.getEndDate(),
                Double.parseDouble(decimalFormat.format(finalPrice)),
                price.getPrice());
    }
}
