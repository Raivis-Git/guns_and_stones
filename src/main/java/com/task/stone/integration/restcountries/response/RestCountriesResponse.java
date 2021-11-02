package com.task.stone.integration.restcountries.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestCountriesResponse {

	private final String name;
	private final String capital;
	private final Long population;
	private final List<Currency> currencies;
	private Double area;
	
	public RestCountriesResponse(String name, String capital, Long population, List<Currency> currencies) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.currencies = currencies;
	}
	
		public Double calculatePopulationDensity() {
		return population/area;
	}
	
	public Double getArea() {
		return area;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public Long getPopulation() {
		return population;
	}
	
	public List<Currency> getCurrencies() {
		return currencies;
	}
	
	public static class Currency {
		private String code;
		private String name;
		private String symbol;
		
		public String getCode() {
			return code;
		}
		
		public String getName() {
			return name;
		}
		
		public String getSymbol() {
			return symbol;
		}
	}

}
