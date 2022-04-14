package com.customerfraud.notification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerfraud.clients.fraud.model.NotificationRequest;
import com.customerfraud.notification.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;

	@PostMapping
	public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
		log.info("Notification came.... {}",notificationRequest);
		notificationService.send(notificationRequest);
		
	}
}
