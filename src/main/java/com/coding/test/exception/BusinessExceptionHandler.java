package com.coding.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity handleException(BusinessException ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
