package com.springcomerce.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcomerce.orderservice.dao.Order;
import com.springcomerce.orderservice.dao.OrderItems;
import com.springcomerce.orderservice.dao.OrderItemsRepository;
import com.springcomerce.orderservice.dao.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemsRepository iterepo;
	
	@Transactional
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public Order getById(Integer oid) {
		return orderRepo.findById(oid).orElseThrow(()-> new RuntimeException(" OID not Found"));
	}
}
