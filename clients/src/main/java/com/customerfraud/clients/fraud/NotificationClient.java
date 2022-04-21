package com.customerfraud.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.customerfraud.clients.fraud.model.NotificationRequest;

@FeignClient(name = "notification",url = "${clients.notificaiton.url}")
public interface NotificationClient {
	
	@PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
