package com.example.spring.eventbus;

public interface NotificationService {

  void initiateNotification(NotificationData notificationData) throws InterruptedException;
}