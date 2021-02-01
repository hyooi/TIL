package com.elevenst.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// url미설정 시 ribbon통해서 로드밸런싱되며, eureka에서 product의 url을 가져와 요청함.
// ribbon 및 eureka없이 feign으로만 요청도 가능
// url미설정하면 ribbon + eureka + hystrix 통합
@FeignClient(name = "product")
public interface FeignProductRemoteService {

  @RequestMapping("/products/{productId}")
  String getProductInfo(@PathVariable("productId") String productId);
}
