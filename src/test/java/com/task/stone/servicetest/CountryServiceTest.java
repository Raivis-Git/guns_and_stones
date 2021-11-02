package com.task.stone.servicetest;

import com.task.stone.model.Country;
import com.task.stone.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CountryServiceTest {
	
	@Autowired
	private CountryService countryService;
	
	@Test
	public void addCountry() {
		countryService.createCountry("Latvia", "Riga", 200000L);
		Country country = countryService.getCountryByName("Latvia").orElse(new Country());
		assertEquals("Latvia", country.getName());
	}
	
	@Test
	public void getTop10WithBiggestPopulationTest() {
		assertEquals(10, countryService.get10WithBiggestPopulation().size());
	}
	
	@Test
	public void getTop10WithBiggestAreaTest() {
		assertEquals(10, countryService.get10WithBiggestArea().size());
	}
	
	@Test
	public void getTop10WithBiggestPopulationDensityTest() {
		assertEquals(10, countryService.get10WithBiggestPopulationDensity().size());
	}
	
}
