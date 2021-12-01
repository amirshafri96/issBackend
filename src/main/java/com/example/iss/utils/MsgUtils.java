package com.example.iss.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MsgUtils {
	public static <T> T jsonStringToObj(String json, Class<T> c)  throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, c);
		} catch (IOException e) {
			throw e;
		}
	}
}
