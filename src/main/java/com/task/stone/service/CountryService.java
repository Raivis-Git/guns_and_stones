package com.task.stone.service;

import com.task.stone.integration.restcountries.RestCountries;
import com.task.stone.integration.restcountries.response.RestCountriesResponse;
import com.task.stone.model.Country;
import com.task.stone.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {
	
	private final CountryRepository countryRepository;
	
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public void createCountry(String name, String capital, Long population) {
		countryRepository.save(new Country(name, capital, population));
	}
	
	public Optional<Country> getCountryById(Long countryId) {
		return countryRepository.findById(countryId);
	}
	
	public Optional<Country> getCountryByName(String countryName) {
		return countryRepository.findByName(countryName);
	}
	
	public List<RestCountriesResponse> getTop10WithBiggestPopulation() {
		List<RestCountriesResponse> restCountriesList = new RestCountries().getResponseEU();
		return restCountriesList.stream()
				.filter(restCountry -> restCountry.getPopulation() != null)
				.sorted(Comparator.comparingLong(RestCountriesResponse::getPopulation).reversed())
				.limit(10)
				.map(restCountry -> new RestCountriesResponse(
						restCountry.getName(),
						restCountry.getCapital(),
						restCountry.getPopulation(),
						restCountry.getCurrencies()))
				.collect(Collectors.toList());
	}
	
	public List<RestCountriesResponse> getTop10WithBiggestArea() {
		List<RestCountriesResponse> restCountriesList = new RestCountries().getResponseEU();
		return restCountriesList.stream()
				.filter(restCountry -> restCountry.getArea() != null)
				.sorted(Comparator.comparingDouble(RestCountriesResponse::getArea).reversed())
				.limit(10)
				.map(restCountry -> new RestCountriesResponse(
						restCountry.getName(),
						restCountry.getCapital(),
						restCountry.getPopulation(),
						restCountry.getCurrencies()))
				.collect(Collectors.toList());
	}
	
	public List<RestCountriesResponse> getTop10WithBiggestPopulationDensity() {
		List<RestCountriesResponse> restCountriesList = new RestCountries().getResponseEU();
		return restCountriesList.stream()
				.filter(restCountry -> restCountry.getPopulation() != null && restCountry.getArea() != null)
				.sorted(Comparator.comparingDouble(RestCountriesResponse::calculatePopulationDensity).reversed())
				.limit(10)
				.map(restCountry -> new RestCountriesResponse(
						restCountry.getName(),
						restCountry.getCapital(),
						restCountry.getPopulation(),
						restCountry.getCurrencies()))
				.collect(Collectors.toList());
	}
	
}
