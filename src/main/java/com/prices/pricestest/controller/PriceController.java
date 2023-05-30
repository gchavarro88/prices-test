package com.prices.pricestest.controller;

import com.prices.pricestest.dto.PriceResponse;
//import com.prices.pricestest.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {


    @PostMapping
    public ResponseEntity<PriceResponse> getPrice(@RequestBody PriceResponse priceRequest) {
        if
    }
}
