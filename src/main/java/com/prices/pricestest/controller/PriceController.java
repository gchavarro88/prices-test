package com.prices.pricestest.controller;

import com.prices.pricestest.dto.PriceRequest;
import com.prices.pricestest.dto.PriceResponse;
import com.prices.pricestest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService service;

    @PostMapping
    public ResponseEntity<PriceResponse> getPrice(@RequestBody @Validated PriceRequest priceRequest) {
        Optional<PriceResponse> result = service.getFinalPrice(priceRequest.getBrandId(), priceRequest.getProductId(),
                priceRequest.getDate());

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {
        Map<String, String> errorResult = new TreeMap<>();

        List<String> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        for (int i= 0; i < errorMessages.size(); i++) {
            errorResult.put("Error " + i, errorMessages.get(i));
        }

        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, errorResult.toString()).build();
    }
}
