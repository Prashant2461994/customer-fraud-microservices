package com.customerfraud.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.customerfraud.amqp.producer.RabbitMQMessageProducer;
import com.customerfraud.notification.config.NotificationConfig;

@SpringBootApplication(scanBasePackages = { "com.customerfraud.notification", "com.customerfraud.amqp" })
@EnableEurekaClient
public class NotificationApp implements CommandLineRunner {

	@Autowired
	RabbitMQMessageProducer producer;

	@Autowired
	NotificationConfig notificationConfig;

	public static void main(String[] args) {
		SpringApplication.run(NotificationApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * producer.publish("foo", notificationConfig.getInternalExchange(),
		 * notificationConfig.getInternalNotificationRoutingKeyExchange());
		 */
	}
}
