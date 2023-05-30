package com.prices.pricestest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prices.pricestest.dto.PriceRequest;
import com.prices.pricestest.model.Brand;
import com.prices.pricestest.model.Price;
import com.prices.pricestest.model.Product;
import com.prices.pricestest.repository.BrandRepository;
import com.prices.pricestest.repository.PriceRepository;
import com.prices.pricestest.repository.ProductRepository;
import com.prices.pricestest.service.PriceService;
import com.prices.pricestest.utilities.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PricesTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PriceService service;


	@Autowired
	BrandRepository brandRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	PriceRepository priceRepository;

	@BeforeEach
	public void setup() {
		priceRepository.deleteAll();
	}

	@Test
	public void testScenariosHappyPath() throws Exception {

		Brand brand = new Brand(1, "ZARA");
		Product product = new Product(35455, "T-Shirt");

		initializeData(brand, product);
		//Scenario 1
		PriceRequest request = new PriceRequest(LocalDateTime.parse("2020-06-14T10:00:00"), product.getProductId(),
				brand.getBrandId());
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		String requestJson = objectMapper.writeValueAsString(request);

		MockHttpServletResponse response = mockMvc.perform(post("/price")
						.contentType("application/json")
						.content(requestJson))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(product.getProductId()))
				.andExpect(jsonPath("$.brandId").value(brand.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.finalPrice").value(35.5))
				.andExpect(status().isOk()).andReturn().getResponse();
	}

	private void initializeData(Brand brand, Product product) {

		productRepository.save(product);
		brandRepository.save(brand);

		List<Price> prices = List.of(
				new Price(
						brand,
						LocalDateTime.parse("2020-06-14T00:00:00"),
						LocalDateTime.parse("2020-12-31T23:59:59"),
						35.50,
						Currency.EUR,
						1,
						product,
						0),
				new Price(
						brand,
						LocalDateTime.parse("2020-06-14T15:00:00"),
						LocalDateTime.parse("2020-06-14T18:30:00"),
						25.45,
						Currency.EUR,
						2,
						product,
						1),
				new Price(
						brand,
						LocalDateTime.parse("2020-06-15T00:00:00"),
						LocalDateTime.parse("2020-06-15T11:00:00"),
						30.50,
						Currency.EUR,
						3,
						product,
						1),
				new Price(
						brand,
						LocalDateTime.parse("2020-06-15T16:00:00"),
						LocalDateTime.parse("2020-12-31T23:59:59"),
						38.95,
						Currency.EUR,
						4,
						product,
						1)
		);

		priceRepository.saveAll(prices);
	}

}
