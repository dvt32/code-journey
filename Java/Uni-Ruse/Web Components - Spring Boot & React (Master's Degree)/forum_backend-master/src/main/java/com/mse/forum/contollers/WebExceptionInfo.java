package com.mse.forum.contollers;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebExceptionInfo {
	private HttpStatus code;
	private String summary;
	private String description;
}