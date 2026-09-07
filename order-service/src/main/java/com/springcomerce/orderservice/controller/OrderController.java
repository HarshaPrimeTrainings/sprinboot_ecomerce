package com.springcomerce.orderservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcomerce.orderservice.dao.Order;
import com.springcomerce.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
//@CrossOrigin(origins = "http://localhost:9097",allowedHeaders = {HttpHeaders.CONTENT_TYPE,HttpHeaders.AUTHORIZATION},methods = {RequestMethod.GET,RequestMethod.POST})
public class OrderController {

	OrderService orderservice;
	
	OrderController(OrderService orderservice){
		this.orderservice = orderservice;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order ord){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderservice.saveOrder(ord));
	}
	
	@GetMapping("/{oid}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer oid){
		return ResponseEntity.status(HttpStatus.OK).body(orderservice.getById(oid));
	}
	
}
