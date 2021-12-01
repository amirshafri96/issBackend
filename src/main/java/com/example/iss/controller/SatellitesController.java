package com.example.iss.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.iss.service.SatellitesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin
@RequestMapping(value = "iss")
public class SatellitesController {
	
	@Autowired
	SatellitesService ss;

	@GetMapping("/satellites")
	public String getPosition(@RequestBody String payload) throws Exception {
		return ss.getPosition(payload);
	}
}
