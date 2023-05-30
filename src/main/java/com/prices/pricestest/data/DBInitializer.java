package com.prices.pricestest.data;


import com.prices.pricestest.model.Brand;
import com.prices.pricestest.model.Price;
import com.prices.pricestest.model.Product;
import com.prices.pricestest.repository.BrandRepository;
import com.prices.pricestest.repository.PriceRepository;
import com.prices.pricestest.repository.ProductRepository;
import com.prices.pricestest.utilities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DBInitializer {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceRepository priceRepository;

    @Bean
    public CommandLineRunner loadDataBase() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Product> productList = List.of(
                        new Product(35455, "T-Shirt"),
                        new Product(35456, "Sweater"),
                        new Product(35457, "Blue Jean"),
                        new Product(35458, "Jacket")
                );

                productRepository.saveAll(productList);

                List<Brand> brandList = List.of(
                        new Brand(1, "ZARA"),
                        new Brand(2, "NIKE"),
                        new Brand(3, "GEF")
                );

                brandRepository.saveAll(brandList);

                List<Price> prices = List.of(
                        new Price(
                                brandList.get(0),
                                LocalDateTime.parse("2020-06-14T00:00:00"),
                                LocalDateTime.parse("2020-12-31T23:59:59"),
                                35.50,
                                Currency.EUR,
                                1,
                                productList.get(0),
                                0),
                        new Price(
                                brandList.get(0),
                                LocalDateTime.parse("2020-06-14T15:00:00"),
                                LocalDateTime.parse("2020-06-14T18:30:00"),
                                25.45,
                                Currency.EUR,
                                2,
                                productList.get(0),
                                1),
                        new Price(
                                brandList.get(0),
                                LocalDateTime.parse("2020-06-15T00:00:00"),
                                LocalDateTime.parse("2020-06-15T11:00:00"),
                                30.50,
                                Currency.EUR,
                                3,
                                productList.get(0),
                                1),
                        new Price(
                                brandList.get(0),
                                LocalDateTime.parse("2020-06-15T16:00:00"),
                                LocalDateTime.parse("2020-12-31T23:59:59"),
                                38.95,
                                Currency.EUR,
                                4,
                                productList.get(0),
                                1)
                );

                priceRepository.saveAll(prices);
            }
        };
    }
}
