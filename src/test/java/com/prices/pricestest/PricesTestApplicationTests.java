package com.prices.pricestest;

import com.prices.pricestest.model.Brand;
import com.prices.pricestest.model.Price;
import com.prices.pricestest.model.Product;
import com.prices.pricestest.repository.BrandRepository;
import com.prices.pricestest.repository.PriceRepository;
import com.prices.pricestest.repository.ProductRepository;
import com.prices.pricestest.utilities.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
	BrandRepository brandRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	PriceRepository priceRepository;

	private final Brand BRAND_TEST = new Brand(1, "ZARA");
	private final Product PRODUCT_TEST = new Product(35455, "T-Shirt");

	@BeforeEach
	public void setup() {
		priceRepository.deleteAll();
		initializeData(BRAND_TEST, PRODUCT_TEST);
	}

	@Test
	public void testScenario1HappyPath() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-14T10:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(PRODUCT_TEST.getProductId()))
				.andExpect(jsonPath("$.brandId").value(BRAND_TEST.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.finalPrice").value(35.5))
				.andExpect(status().isOk()).andReturn().getResponse();
	}

	@Test
	public void testScenario2HappyPath() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-14T16:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(PRODUCT_TEST.getProductId()))
				.andExpect(jsonPath("$.brandId").value(BRAND_TEST.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(2))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
				.andExpect(jsonPath("$.finalPrice").value(25.45))
				.andExpect(status().isOk()).andReturn().getResponse();
	}

	@Test
	public void testScenario3HappyPath() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-14T21:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(PRODUCT_TEST.getProductId()))
				.andExpect(jsonPath("$.brandId").value(BRAND_TEST.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.finalPrice").value(35.5))
				.andExpect(status().isOk()).andReturn().getResponse();
	}

	@Test
	public void testScenario4HappyPath() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-15T10:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(PRODUCT_TEST.getProductId()))
				.andExpect(jsonPath("$.brandId").value(BRAND_TEST.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(3))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
				.andExpect(jsonPath("$.finalPrice").value(30.5))
				.andExpect(status().isOk()).andReturn().getResponse();
	}


	@Test
	public void testScenario5HappyPath() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-16T21:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andExpect(jsonPath("$.productId").value(PRODUCT_TEST.getProductId()))
				.andExpect(jsonPath("$.brandId").value(BRAND_TEST.getBrandId()))
				.andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.finalPrice").value(38.95))
				.andExpect(status().isOk()).andReturn().getResponse();
	}

	@Test
	public void testBadRequest() throws Exception {

		//No brandId
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2020-06-16T21:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isBadRequest()).andReturn().getResponse();

		//No productId
		response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("date", "2020-06-16T21:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isBadRequest()).andReturn().getResponse();

		//No date
		response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isBadRequest()).andReturn().getResponse();
	}

	@Test
	public void testNotFound() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/price")
						.param("brandId", String.valueOf(BRAND_TEST.getBrandId()))
						.param("productId", String.valueOf(PRODUCT_TEST.getProductId()))
						.param("date", "2018-06-16T21:00:00")
						.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isNotFound()).andReturn().getResponse();
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
