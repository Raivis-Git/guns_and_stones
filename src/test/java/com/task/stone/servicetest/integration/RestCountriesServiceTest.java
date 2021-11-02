package com.task.stone.servicetest.integration;

import com.task.stone.integration.restcountries.RestCountriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RestCountriesServiceTest {
	
	@Autowired
	RestCountriesService restCountriesService;
	
	@Test
	public void getCountries() {
		assertNotNull(restCountriesService.getRestCountry());
	}
	
}
