package com.elevenst.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductRemoteServiceImpl implements ProductRemoteService {

  public static final String URL = "http://product/products/";

  private final RestTemplate restTemplate;

  public ProductRemoteServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  @HystrixCommand(commandKey = "productInfo", fallbackMethod = "getProductInfoFallback",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
      }, //timeout미설정 시 기본 1000ms
      threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "30"),
          @HystrixProperty(name = "maxQueueSize", value = "101"),
          @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
          @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
          @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
          @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value =
              "1440")})
  public String getProductInfo(String productId) {
    return restTemplate.getForObject(URL + productId, String.class);
  }

  public String getProductInfoFallback(String productId, Throwable t) {
    System.out.println("t = " + t);
    return "[This product is sold out]";
  }
}
