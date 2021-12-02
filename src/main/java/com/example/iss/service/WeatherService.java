package com.example.iss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

	private static final String url = "https://weather.ls.hereapi.com/weather/1.0/report.json?product=forecast_7days_simple&name=";
	private static final String apiKey = "&apiKey=fIKrh97Jg90vG1egNCBQp_MS22u6iOWTQlU-sgaxeEc";

	private static String setupParameter(String cityName) {
		return url + cityName + apiKey;
	}
	
	public static String getWeather(String cityName) {
		String finalUrl = setupParameter(cityName);
		System.out.println(finalUrl);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(finalUrl, String.class);
	}
}
