package com.mse.forum.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mse.forum.contollers.WebExceptionInfo;

public class WebExceptionUtil {

	public static ResponseEntity<Object> build(HttpStatus code, String summary, String description) {
		try {
			WebExceptionInfo error = WebExceptionInfo.builder()
				.summary(summary)
				.description(summary)
				.code(code)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String string = mapper.writeValueAsString(error);
			
			return new ResponseEntity<>(string, code);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}