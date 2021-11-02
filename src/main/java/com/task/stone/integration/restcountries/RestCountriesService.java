package com.task.stone.integration.restcountries;

import com.task.stone.integration.restcountries.response.RestCountriesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestCountriesService {
	
	public RestCountriesResponse getRestCountry() {
		List<RestCountriesResponse> response = new RestCountries().getResponseEU();
		return response.iterator().next();
	}
	
}
