package com.example.iss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.iss.requestModel.PositionRequest;
import com.example.iss.utils.MsgUtils;

@Service
public class SatellitesService {
private final static String satelliteEndpoint = "https://api.wheretheiss.at/v1/satellites/25544/positions?timestamps=";
	public static String getPosition(String payload) throws Exception {
		try {
			PositionRequest positionRequest = MsgUtils.jsonStringToObj(payload, PositionRequest.class);
			String url = prepareUrl(satelliteEndpoint, positionRequest);
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(url, String.class);
		} catch (Exception e) {
			throw e;
		}

	}

	public static String prepareUrl(String url, PositionRequest positionRequest) {
		return url + positionRequest.getStartTime() + "," + positionRequest.getEndTime() + "&" + "units=miles";
	}

}
