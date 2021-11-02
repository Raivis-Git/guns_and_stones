package com.task.stone.integration.restcountries;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.task.stone.integration.restcountries.response.RestCountriesResponse;
import javassist.tools.web.BadHttpRequest;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.util.List;

public class RestCountries {
	
	private List<RestCountriesResponse> request(String url) {
		
		Gson gson = new Gson();
		HttpGet request = new HttpGet(url);
		request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpResponse response = httpClient.execute(request);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (HttpURLConnection.HTTP_OK == statusCode)
				return gson.fromJson(EntityUtils.toString(response.getEntity()), new TypeToken<List<RestCountriesResponse>>() {}.getType());
			
			throw new BadHttpRequest();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<RestCountriesResponse> getResponseEU() {
		return request("https://restcountries.com/v2/regionalbloc/eu");
	}
	
}
