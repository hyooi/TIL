package com.example.spring.eventbus;

import lombok.val;
import reactor.bus.Event;
import reactor.fn.Consumer;

public class NotificationConsumer implements Consumer<Event<NotificationData>> {

  private final NotificationService service;

  public NotificationConsumer(NotificationService service) {
    this.service = service;
  }

  @Override
  public void accept(Event<NotificationData> notificationDataEvent) {
    val notificationData = notificationDataEvent.getData();
    try {
      service.initiateNotification(notificationData);
    } catch (InterruptedException ignored) {

    }
  }
}
