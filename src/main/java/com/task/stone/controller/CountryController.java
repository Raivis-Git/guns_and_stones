package com.task.stone.controller;

import com.task.stone.model.Country;
import com.task.stone.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/country")
public class CountryController {
	
	private final CountryService countryService;
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@PostMapping
	public ResponseEntity<?> addCountry(@RequestBody Country country) {
		countryService.createCountry(country.getName(), country.getCapital(), country.getPopulation());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	@RequestMapping("/{countryId}")
	public ResponseEntity<?> getCountry(@PathVariable Long countryId) {
		return ResponseEntity.ok(countryService.getCountryById(countryId));
	}
	
	@GetMapping
	@RequestMapping("/top10WithBiggestPopulation")
	public ResponseEntity<?> top10withBiggestPopulation() {
		return ResponseEntity.ok(countryService.getTop10WithBiggestPopulation());
	}
	
	@GetMapping
	@RequestMapping("/top10WithBiggestArea")
	public ResponseEntity<?> top10withBiggestArea() {
		return ResponseEntity.ok(countryService.getTop10WithBiggestArea());
	}
	
	@GetMapping
	@RequestMapping("/top10WithBiggestPopulationDensity")
	public ResponseEntity<?> top10withBiggestPopulationDensity() {
		return ResponseEntity.ok(countryService.getTop10WithBiggestPopulationDensity());
	}
	
}
