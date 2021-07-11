package com.example.spring.handlerresolver;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerConfigure implements WebMvcConfigurer {

  private final ArgumentResolver argumentResolver;

  public HandlerConfigure(ArgumentResolver argumentResolver) {
    this.argumentResolver = argumentResolver;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(argumentResolver);
  }
}
