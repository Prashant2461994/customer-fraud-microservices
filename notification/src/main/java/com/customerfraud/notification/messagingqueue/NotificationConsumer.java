package com.customerfraud.notification.messagingqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customerfraud.clients.fraud.model.NotificationRequest;
import com.customerfraud.notification.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationConsumer {

	@Autowired
	private NotificationService notificationService;

	@RabbitListener(queues= "${rabbitmq.queue.notification}")
	public void consumer(NotificationRequest notificationRequest) {
		log.info("Consumed {} from queue", notificationRequest);
		notificationService.send(notificationRequest);
		log.info("Saved {} consumed message", notificationRequest);
	}
}
