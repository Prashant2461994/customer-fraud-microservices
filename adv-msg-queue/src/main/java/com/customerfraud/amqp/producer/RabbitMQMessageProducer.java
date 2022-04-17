package com.customerfraud.amqp.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMQMessageProducer {

	@Autowired
	@Qualifier("customAmqp")
	private AmqpTemplate amqpTemplate;

	public void publish(Object payload, String exchange, String routingKey) {
		log.info("Publishing to exhange {} using routingkey {} Payload: {}", exchange, routingKey, payload);
		amqpTemplate.convertAndSend(exchange, routingKey, payload);
		log.info("Published to exhange {} using routingkey {} Payload: {}", exchange, routingKey, payload);
	}
}
