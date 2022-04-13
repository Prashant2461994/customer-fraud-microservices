package com.customerfraud.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerfraud.notification.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
