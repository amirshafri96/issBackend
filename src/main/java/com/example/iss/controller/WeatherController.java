package com.example.iss.controller;

import com.example.iss.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "weather")
public class WeatherController {
    @Autowired
	WeatherService ss;

	@GetMapping("/satellites")
	public String getPosition() throws Exception {
		ss.getData();
        return null;
    }
		
}
