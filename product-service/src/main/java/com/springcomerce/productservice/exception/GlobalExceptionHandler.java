package com.springcomerce.productservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotAvilableException.class)
	public ResponseEntity<Object> handleProductNotFound(){
		Map<String, Object> exceptionBody = new HashMap<>();
		exceptionBody.put("expmessage", "Product is Not found");
		exceptionBody.put("timestamp", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionBody);
	}
}
