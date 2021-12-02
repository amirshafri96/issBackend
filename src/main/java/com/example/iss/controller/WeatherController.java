package com.example.iss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.iss.service.WeatherService;

@RestController
@CrossOrigin
@RequestMapping(value = "weather")
public class WeatherController {
	@Autowired
	WeatherService ws;

	@GetMapping("/getForecastForCity")
	public String getWeather(@RequestParam String cityName) throws Exception {
		System.out.println(cityName);
		return ws.getWeather(cityName);
	}

	@GetMapping("/getWeatherByLocation")
	public String getWeatherByLocation(@RequestParam double lat, double lng) throws Exception {
		System.out.println(lat + " " + lng);
		return ws.getWeatherByLocation(lat, lng);
	}
}
