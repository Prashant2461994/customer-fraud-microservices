package com.customerfraud.notification.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerfraud.clients.fraud.model.NotificationRequest;
import com.customerfraud.notification.model.Notification;
import com.customerfraud.notification.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private  NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("Prashant")
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
	
}
