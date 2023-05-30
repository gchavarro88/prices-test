package com.prices.pricestest.repository;

import com.prices.pricestest.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    @Query("SELECT p FROM Price p WHERE p.brand.brandId = :brandId " +
            "AND p.product.productId = :productId AND p.startDate <= :time AND p.endDate >= :time")
    List<Price> findByBrandIdAndProductIdAndBetweenStartAndEndDates(Integer brandId,
                                                                    Integer productId, LocalDateTime time);
}
