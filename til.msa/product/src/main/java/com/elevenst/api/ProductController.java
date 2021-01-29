package com.elevenst.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping("{productId}")
  public String getProduct(@PathVariable String productId) throws InterruptedException {
    Thread.sleep(2000);

    System.out.println("Called product id " + productId);
    throw new RuntimeException("IO Exception");
//    return "[product id = " + productId +
//        " at " + System.currentTimeMillis() + "]";
  }

}
