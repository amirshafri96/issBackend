package com.example.iss.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.iss.model.Position;
import com.example.iss.service.SatellitesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping(value = "iss")
public class SatellitesController {
	
	@Autowired
	SatellitesService ss;

	@GetMapping("/satellites")
	public List<Position>  getPosition(@RequestParam long startTime) throws Exception {
		System.out.println(startTime);
		return ss.getPosition(startTime);
	}
}
