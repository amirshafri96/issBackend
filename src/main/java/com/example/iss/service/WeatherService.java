package com.example.iss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.iss.model.Forecast;
import com.example.iss.model.Position;
import com.example.iss.utils.MsgUtils;
import com.google.gson.Gson;

@Service
public class WeatherService {

	private static final String url = "https://weather.ls.hereapi.com/weather/1.0/report.json?product=forecast_7days_simple&name=";
	private static final String apiKey = "&apiKey=ujN6RowEVDMxbYcr3CHpzTD4zRTZ66sMoKBCHNfx9CE";

	private static String setupParameter(String cityName) {
		return url + cityName + apiKey;
	}

	public static String getWeather(String cityName) {
		String finalUrl = setupParameter(cityName);
		System.out.println(finalUrl);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(finalUrl, String.class);
	}

	public static String getWeatherByLocation(double lat, double lng) {
		String baseURL = "https://weather.ls.hereapi.com/weather/1.0/report.json?product=observation&latitude=";
		String baseUrlLocation = baseURL + lat + "&longitude=" + lng + "&oneobservation=true" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(baseUrlLocation, String.class);
	}

	public static List<Forecast> getWeatherByPosition(List<Position> payload) {
		Gson g = new Gson();
		List<Forecast> output = new ArrayList<>();
		for (Position p : payload) {
			String output1 = getWeatherByLocation(p.getLatitude(), p.getLongitude());
			Forecast forecast = g.fromJson(output1, Forecast.class);
			output.add(forecast);
		}
		return output;
	
	}
}
