package com.springcomerce.notificationservice.dto;

public record OrderEvenet (
		 Integer oid,
		 String email,
		 Double price) {}
