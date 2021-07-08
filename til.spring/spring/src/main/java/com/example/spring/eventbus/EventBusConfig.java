package com.example.spring.eventbus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class EventBusConfig {

  @Bean
  public Environment env() {
    return Environment.initializeIfEmpty().assignErrorJournal();
  }
  
  @Bean
  public EventBus createEventBus(Environment env) {
    return EventBus.create(env, Environment.THREAD_POOL);
//    return EventBus.create(env, Environment.newDispatcher(100, 1,
//        DispatcherType.THREAD_POOL_EXECUTOR)); //사용자정의 스레드풀로 EventBus생성
  }
}
