package com.example.iss.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	public static <T> List<T> jsonStringToObjList(String json, Class<T> c) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, c));
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	public static String objToJSONString(Object obj) {
		String result = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
