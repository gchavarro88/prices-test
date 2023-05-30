package com.prices.pricestest.data;


import com.prices.pricestest.model.Brand;
import com.prices.pricestest.model.Price;
import com.prices.pricestest.model.PriceList;
import com.prices.pricestest.model.Product;
import com.prices.pricestest.repository.BrandRepository;
import com.prices.pricestest.repository.PriceListRepository;
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
    PriceListRepository priceListRepository;

    @Autowired
    PriceRepository priceRepository;

    @Bean
    public CommandLineRunner loadDataBase() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Product> productList = List.of(
                        new Product("T-Shirt"),
                        new Product("Sweater"),
                        new Product( "Blue Jean"),
                        new Product("Jacket")
                );

                productRepository.saveAll(productList);

                List<Brand> brandList = List.of(
                        new Brand("Zara"),
                        new Brand("Nike"),
                        new Brand( "Adidas")
                );

                brandRepository.saveAll(brandList);

                List<PriceList> priceLists = List.of(
                        new PriceList(20),
                        new PriceList(10),
                        new PriceList(15),
                        new PriceList(5),
                        new PriceList(30),
                        new PriceList(50)
                );

                priceListRepository.saveAll(priceLists);

                List<Price> priceRecords = List.of(
                        new Price(
                                brandList.get(0),
                                LocalDateTime.parse("2018-12-30T19:34:50.63"),
                                LocalDateTime.parse("2018-12-31T19:34:50.63"),
                                12.65,
                                Currency.EUR,
                                priceLists.get(0),
                                productList.get(0),
                                1),
                        new Price(
                                brandList.get(1),
                                LocalDateTime.parse("2018-12-30T19:34:50.63"),
                                LocalDateTime.parse("2018-12-31T19:34:50.63"),
                                12.65,
                                Currency.EUR,
                                priceLists.get(1),
                                productList.get(1),
                                1),
                        new Price(
                                brandList.get(2),
                                LocalDateTime.parse("2018-12-30T19:34:50.63"),
                                LocalDateTime.parse("2018-12-31T19:34:50.63"),
                                12.65,
                                Currency.EUR,
                                priceLists.get(2),
                                productList.get(2),
                                1)
                );

                priceRepository.saveAll(priceRecords);
            }
        };
    }
}
