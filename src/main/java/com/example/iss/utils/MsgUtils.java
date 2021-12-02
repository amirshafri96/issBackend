package com.example.iss.utils;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MsgUtils {
	private final static Logger log = LoggerFactory.getLogger(MsgUtils.class);
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
			log.error("Error in ObjToJSONString with error: " + e, e);
			
		}
		
		return result;
	}
}
