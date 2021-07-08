package com.example.spring.eventbus;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void initiateNotification(NotificationData notificationData) throws InterruptedException {
    System.out
        .println("notification service started for notification ID: " + notificationData.getId());
    Thread.sleep(5000);
    System.out
        .println("notification service ended for notification ID: " + notificationData.getId());
  }
}
