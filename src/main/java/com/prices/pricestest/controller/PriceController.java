package com.prices.pricestest.controller;

import com.prices.pricestest.dto.PriceRequest;
import com.prices.pricestest.dto.PriceResponse;
import com.prices.pricestest.service.PriceService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService service;

    @GetMapping
    @Validated
    public ResponseEntity<PriceResponse> getPrice(@NotNull @Min (1) @RequestParam(required = true) Integer brandId,
                                                  @NotNull @Min(1) @RequestParam(required = true) Integer productId,
                                                  @NotNull @RequestParam(required = true) LocalDateTime date) {

        PriceRequest priceRequest = new PriceRequest(date, productId, brandId);
        Optional<PriceResponse> result = service.getFinalPrice(priceRequest);

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
