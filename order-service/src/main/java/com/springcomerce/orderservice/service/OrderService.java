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
		
		order.getOrderItems().forEach(ord->{
			OrderItems item = new OrderItems();
		item.setName(ord.getName());
		item.setPrice(ord.getPrice());
		item.setOrder(order);
		item.setQuantity(ord.getQuantity());
			iterepo.save(item);
		});
		return orderRepo.save(order);
	}
}
