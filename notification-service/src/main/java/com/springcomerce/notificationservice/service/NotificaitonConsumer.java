package com.springcomerce.notificationservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springcomerce.notificationservice.dto.OrderEvenet;

@Service
public class NotificaitonConsumer {
	


	@KafkaListener(topics = "orders-topic",groupId = "notifications-group")
	public void consumeEvents(OrderEvenet oe) {
		String subject = "Order Event Recieved "+ oe.oid() + " from "+ oe.email() + " price " + oe.price();
		
		// send the email
		System.out.println(subject);
		System.out.println("Email Sent");
	}
}
