package com.prices.pricestest.controller;

import com.prices.pricestest.dto.PriceResponse;
import com.prices.pricestest.service.PriceServiceImpl;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceServiceImpl service;

    @GetMapping
    @Validated
    public ResponseEntity<PriceResponse> getPrice(@NotNull @Min (1) @RequestParam(required = true) Integer brandId,
                                                  @NotNull @Min(1) @RequestParam(required = true) Integer productId,
                                                  @NotNull @RequestParam(required = true) LocalDateTime date) {

        Optional<PriceResponse> result = service.getFinalPrice(brandId, productId, date);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
