package com.example.iss.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.iss.model.Position;
import com.example.iss.utils.MsgUtils;

@Service
public class SatellitesService {
	private final static String satelliteEndpoint = "https://api.wheretheiss.at/v1/satellites/25544/positions?timestamps=";

	public String getPosition(long startTime) throws Exception {
		try {
			// get data before start time
			List<Long> beforeStartTime = getOneHour(startTime, false);
			// get data after end time
			List<Long> afterStartTime = getOneHour(startTime, true);

			// request position before start time
			String url = prepareUrl(satelliteEndpoint, beforeStartTime);
			System.out.println(url);
			String outputBeforeStartTime = getResult(url);
			// request position after start time
			String outputAfterStartTime = getResult(prepareUrl(satelliteEndpoint, afterStartTime));
			// request position for start time
			String outputStartTime = getResult(prepareUrl(satelliteEndpoint, new ArrayList<Long>() {
				{
					add(startTime);
				}
			}));
			
			List<Position> positions1 = MsgUtils.jsonStringToObjList(outputBeforeStartTime, Position.class);
			List<Position> positions2 = MsgUtils.jsonStringToObjList(outputStartTime, Position.class);
			List<Position> positions3 = MsgUtils.jsonStringToObjList(outputAfterStartTime, Position.class);
			List<Position> result = new ArrayList<>();
			result.addAll(positions1);
			result.addAll(positions2);
			result.addAll(positions3);
			return MsgUtils.objToJSONString(result);

		} catch (Exception e) {
			throw e;
		}

	}

	public static String getResult(String url) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class);
	}

	public static String prepareUrl(String url, List<Long> requestTime) {
		for (Long rt : requestTime) {
			url = url + rt +",";
		}
		String output = url.substring(0, url.length()-1);
		
		return output + "&" + "units=miles";
	}

	public static List<Long> getOneHour(long startTime, boolean isAfter) {
		List<Long> result = new ArrayList<Long>();
		Date date = new Date(startTime);
		for (int i = 0; i < 6; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, isAfter ? -10 : 10);
			long output = calendar.getTimeInMillis();
			result.add(output);
			date = calendar.getTime();
		}
		return result;

	}

}
