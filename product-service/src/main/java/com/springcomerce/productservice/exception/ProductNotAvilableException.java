package com.springcomerce.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotAvilableException extends RuntimeException{

	public ProductNotAvilableException(String msg) {
		super(msg);
		
	}

}
