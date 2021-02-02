package com.elevenst.service;

import com.elevenst.service.FeignProductRemoteService.FeignProductRemoteServiceFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// url미설정 시 ribbon통해서 로드밸런싱되며, eureka에서 product의 url을 가져와 요청함.
// ribbon 및 eureka없이 feign으로만 요청도 가능
// url미설정하면 ribbon + eureka + hystrix 통합
@FeignClient(name = "product", fallbackFactory =
    FeignProductRemoteServiceFallbackFactory.class
//    fallback = FeignProductRemoteServiceFallbackImpl.class
)
public interface FeignProductRemoteService {

  @RequestMapping("/products/{productId}")
  String getProductInfo(@PathVariable("productId") String productId);

  @Component
  class FeignProductRemoteServiceFallbackImpl implements FeignProductRemoteService {

    @Override
    public String getProductInfo(String productId) {
      return "[ this product is sold out]";
    }
  }

  @Component
  class FeignProductRemoteServiceFallbackFactory implements
      FallbackFactory<FeignProductRemoteService> {

    @Override
    public FeignProductRemoteService create(Throwable cause) {
      System.out.println("t = " + cause);
      return productId -> "[ this product is sold out ]";
    }
  }
}
