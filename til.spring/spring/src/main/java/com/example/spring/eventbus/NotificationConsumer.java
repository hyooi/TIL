package com.example.spring.eventbus;

import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {

  private final NotificationService service;

  public NotificationConsumer(NotificationService service) {
    this.service = service;
  }

  @Override
  public void accept(Event<NotificationData> notificationDataEvent) {
    var notificationData = notificationDataEvent.getData();
    try {
      service.initiateNotification(notificationData);
    } catch (InterruptedException ignored) {

    }
  }
}
