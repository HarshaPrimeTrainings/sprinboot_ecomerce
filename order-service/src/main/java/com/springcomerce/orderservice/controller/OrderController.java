package com.springcomerce.orderservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcomerce.orderservice.dao.Order;
import com.springcomerce.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	OrderService orderservice;
	
	OrderController(OrderService orderservice){
		this.orderservice = orderservice;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order ord){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderservice.saveOrder(ord));
	}
	
}
