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
	@RequestMapping("/10WithBiggestPopulation")
	public ResponseEntity<?> tenWithBiggestPopulation() {
		return ResponseEntity.ok(countryService.get10WithBiggestPopulation());
	}
	
	@GetMapping
	@RequestMapping("/10WithBiggestArea")
	public ResponseEntity<?> tenWithBiggestArea() {
		return ResponseEntity.ok(countryService.get10WithBiggestArea());
	}
	
	@GetMapping
	@RequestMapping("/10WithBiggestPopulationDensity")
	public ResponseEntity<?> tenWithBiggestPopulationDensity() {
		return ResponseEntity.ok(countryService.get10WithBiggestPopulationDensity());
	}
	
}
