package com.example.spring.eventbus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {

  private final EventBus eventBus;

  public NotificationController(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @GetMapping("startNotification/{param}")
  public void startNotification(@PathVariable Integer param) {
    for (int i = 0; i < param; i++) {
      var data = new NotificationData();
      data.setId(i);

      eventBus.notify("notificationConsumer", Event.wrap(data));
      System.out.println("Notification " + i + ": notification task submitted successfully.");
    }
  }
}
