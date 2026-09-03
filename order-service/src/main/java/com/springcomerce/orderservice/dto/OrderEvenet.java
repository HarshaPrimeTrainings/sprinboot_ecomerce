package com.springcomerce.orderservice.dto;

public record OrderEvenet (
	 Integer oid,
	 String email,
	 Double price) {}
