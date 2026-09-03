package com.springcomerce.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcomerce.orderservice.dao.Order;
import com.springcomerce.orderservice.dao.OrderItems;
import com.springcomerce.orderservice.dao.OrderItemsRepository;
import com.springcomerce.orderservice.dao.OrderRepository;
import com.springcomerce.orderservice.dto.OrderEvenet;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderEventProducer orderProducer;
	
	@Autowired
	OrderItemsRepository iterepo;
	
	@Transactional
	public Order saveOrder(Order order) {
		
		Order dbOrder =   orderRepo.save(order);
		
		OrderEvenet oe = new OrderEvenet(dbOrder.getOid(),dbOrder.getCustomer().getCsemail(),dbOrder.getPrice());
		orderProducer.publishOrderEvent(oe);
		
		return dbOrder;
	}
	
	public Order getById(Integer oid) {
		return orderRepo.findById(oid).orElseThrow(()-> new RuntimeException(" OID not Found"));
	}
}
