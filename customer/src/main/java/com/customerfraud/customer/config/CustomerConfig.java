package com.customerfraud.customer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

	@Bean(name = "restTemplate")
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Value("${rabbitmq.exchanges.internal}")
	private String internalExchange;

	@Value("${rabbitmq.queue.notification}")
	private String notificationQueue;

	@Value("${rabbitmq.routing-keys.internal-notification}")
	private String internalNotificationRoutingKeyExchange;

	@Bean
	public TopicExchange internalTopicExchange() {
		return new TopicExchange(this.internalExchange);
	}

	@Bean
	public Queue notificationQueue() {
		return new Queue(this.notificationQueue);
	}

	@Bean
	public Binding internalToNotificationBinding() {
		return BindingBuilder.bind(notificationQueue()).to(this.internalTopicExchange())
				.with(this.internalNotificationRoutingKeyExchange);
	}

	public String getInternalExchange() {
		return internalExchange;
	}

	public void setInternalExchange(String internalExchange) {
		this.internalExchange = internalExchange;
	}

	public String getNotificationQueue() {
		return notificationQueue;
	}

	public void setNotificationQueue(String notificationQueue) {
		this.notificationQueue = notificationQueue;
	}

	public String getInternalNotificationRoutingKeyExchange() {
		return internalNotificationRoutingKeyExchange;
	}

	public void setInternalNotificationRoutingKeyExchange(String internalNotificationRoutingKeyExchange) {
		this.internalNotificationRoutingKeyExchange = internalNotificationRoutingKeyExchange;
	}

}
