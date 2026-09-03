package com.springcomerce.orderservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springcomerce.orderservice.dto.OrderEvenet;

@Service
public class OrderEventProducer {
	
	@Value("${order.topic}")
	String topic;
	
	KafkaTemplate<String, OrderEvenet> kafkaTemplate;

	OrderEventProducer(KafkaTemplate<String, OrderEvenet> kafkaTemplate){
		this.kafkaTemplate= kafkaTemplate;
	}
	
	public void publishOrderEvent(OrderEvenet oe) {
		//kafkaTemplate.send(topic,oe.oid().toString(),oe); // publishing message with partiton number
		kafkaTemplate.send(topic,oe); // without partition
	}
}
