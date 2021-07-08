package com.example.spring;

import static reactor.bus.selector.Selectors.$;

import com.example.spring.eventbus.NotificationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.bus.EventBus;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private final EventBus eventBus;
  private final NotificationConsumer consumer;

  public Application(EventBus eventBus, NotificationConsumer consumer) {
    this.eventBus = eventBus;
    this.consumer = consumer;
  }



  @Override
  public void run(String... args) throws Exception {
  eventBus.on($("notificationConsumer"), consumer);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
