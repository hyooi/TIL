package com.spring.webflux.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class AppConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
    ppc.setLocation(new ClassPathResource("application.properties"));
    ppc.setIgnoreUnresolvablePlaceholders(true);

    return ppc;
  }

  @Bean
  public WebClient getWebClient() {
    HttpClient httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(10))
            .addHandlerLast(new WriteTimeoutHandler(10)));

    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder()
        .baseUrl("http://localhost:3000")
        .clientConnector(connector)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }
}
